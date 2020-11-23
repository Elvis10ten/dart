import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import {Container, CardDeck, CardBody, Card} from "../../../components";
import StackedAreaChartCard, {AreaVariable} from "./StackedAreaChartCard";
import {ResponsiveContainer} from "../../../components/recharts";

const { ThreadStats } = require("./../../../proto/ThreadStats_pb")

export default class ThreadCardDeck extends Component {

    static propTypes = {
        threadStatsList: PropTypes.arrayOf(PropTypes.instanceOf(ThreadStats))
    }

    constructor(props) {
        super(props);
        this.state = {
            selectedXReferencePoint: null,
            "New Threads": [],
            "Runnable Threads": [],
            "Blocked Threads": [],
            "Waiting Threads": [],
            "Timed Waiting Threads": [],
            "Terminated Threads": [],
        };
    }

    _formatThreadInfoStats(threadStats) {
        let newThreads = [];
        let runnableThreads = [];
        let blockedThreads = [];
        let waitingThreads = [];
        let timedWaitingThreads = [];
        let terminatedThreads = [];

        threadStats.getThreadsinfoList().map((threadInfo) => {
            switch (threadInfo.getState()) {
                case "NEW":
                    newThreads.push(threadInfo.getName());
                    break;
                case "RUNNABLE":
                    runnableThreads.push(threadInfo.getName());
                    break;
                case "BLOCKED":
                    blockedThreads.push(threadInfo.getName());
                    break;
                case "WAITING":
                    waitingThreads.push(threadInfo.getName());
                    break;
                case "TIMED_WAITING":
                    timedWaitingThreads.push(threadInfo.getName());
                    break;
                case "TERMINATED":
                    terminatedThreads.push(threadInfo.getName());
                    break;
            }
        });

        return ({
            new: newThreads.length,
            newThreadNames: newThreads,

            runnable: runnableThreads.length,
            runnableThreadNames: runnableThreads,

            blocked: blockedThreads.length,
            blockedThreadNames: blockedThreads,

            waiting: waitingThreads.length,
            waitingThreadNames: waitingThreads,

            timedWaiting: timedWaitingThreads.length,
            timedWaitingThreadNames: timedWaitingThreads,

            terminated: terminatedThreads.length,
            terminatedThreadNames: terminatedThreads,

            time: (threadStats.relativeTime / 1000)
        })
    }

    render() {
        const threadInfoStatsList = this.props.threadStatsList.map((threadStats) => {
            return this._formatThreadInfoStats(threadStats);
        })

        return (
            <CardDeck>
                <StackedAreaChartCard
                    items={ threadInfoStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("new", colors['primary'], colors['primary-03']),
                        new AreaVariable("runnable", colors['success'], colors['success-03']),
                        new AreaVariable("blocked", colors['warning'], colors['warning-03']),
                        new AreaVariable("waiting", colors['teal'], colors['teal-03']),
                        new AreaVariable("timedWaiting", colors['yellow'], colors['yellow-03']),
                        new AreaVariable("terminated", colors['purple'], colors['purple-03'])
                    ]}
                    title="Thread Info"
                    subtitle="TODO"
                    referenceXPoint={ this.state.selectedXReferencePoint }
                    onClick={ (payload) => {
                        this.setState({
                            selectedXReferencePoint: payload.activeLabel,
                            "New Threads": payload.activePayload[0].payload.newThreadNames,
                            "Runnable Threads": payload.activePayload[0].payload.runnableThreadNames,
                            "Blocked Threads": payload.activePayload[0].payload.blockedThreadNames,
                            "Waiting Threads": payload.activePayload[0].payload.waitingThreadNames,
                            "Timed Waiting Threads": payload.activePayload[0].payload.timedWaitingThreadNames,
                            "Terminated Threads": payload.activePayload[0].payload.terminatedThreadNames,
                        })
                    }}
                />

                {
                    this._getSelectedTimeThreadInfosView()
                }
            </CardDeck>
        )
    }

    _getSelectedTimeThreadInfosView() {
        if(this.state.selectedXReferencePoint == null) {
            return null;
        }

        return (
            <Card className="mb-3" style={{ "max-height": "300px", "overflow-y": "auto" }}>
                <CardBody>
                    <div className="d-flex">
                        <div>
                            <h6 className="card-title mb-1">
                                Thread States
                            </h6>
                        </div>
                    </div>

                    { this._getThreadInfoView("New Threads") }
                    { this._getThreadInfoView("Runnable Threads") }
                    { this._getThreadInfoView("Blocked Threads") }
                    { this._getThreadInfoView("Waiting Threads") }
                    { this._getThreadInfoView("Timed Waiting Threads") }
                    { this._getThreadInfoView("Terminated Threads") }

                </CardBody>
            </Card>
        )
    }

    _getThreadInfoView(threadState) {
        var position = 0;
        return (
            <Container>
                <b>{ threadState }<br/></b>
                {
                    this.state[threadState].map((threadName) => {
                        position++;
                        return <span>{ position + ". " + threadName}<br/></span>;
                    })
                }
            </Container>
        )
    }
}