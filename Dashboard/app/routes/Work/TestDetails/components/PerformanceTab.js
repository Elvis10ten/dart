import React, { Component } from 'react';
import PropTypes from "prop-types";
import {
    Container
} from "../../../../components";
import BinderCardDeck from "../../components/BinderCardDeck";
import RunSummaryCardDeck from "../../components/RunSummaryCardDeck";
import LifecycleCardDeck from "../../components/LifecycleCardDeck";
import FileIoCardDeck from "../../components/FileIoCardDeck";
import MemoryCardDeck from "../../components/MemoryCardDeck";
import {HeaderRow} from "../../components/HeaderRow";
import GcCardDeck from "../../components/GcCardDeck";
import UnixProcessCardDeck from "../../components/UnixProcessCardDeck";
import NetworkCardDeck from "../../components/NetworkCardDeck";
import ThreadCardDeck from "../../components/ThreadCardDeck";

const { PerformanceReport } = require("./../../../../proto/PerformanceReport_pb")
const { GetWorkRequest } = require("./../../../../proto/GetWorkRequest_pb")
const { WorkServiceClient } = require("./../../../../proto/WorkService_grpc_web_pb")

export default class PerformanceTab extends Component {

    static propTypes = {
        workKey: PropTypes.string,
        deviceKey: PropTypes.string
    }

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            performanceReport: null
        }
    }

    componentDidMount() {
        console.log("fuck5: real fucks!!!!");
        const client = new WorkServiceClient('http://localhost:9090');

        const request = new GetWorkRequest()
        request.workId = "4d653109-136c-4870-b0c9-503786d644f5"
        request.deviceKey = "d3dacf1753e7728f"

        console.log("fuck5:" + JSON.stringify(request));
        client.get(request, {}, (err, response) => {
            console.log("Fuck5 : error: ",err)
            console.log("Fuck5 : response: ",response.getWork())
            /*this.setState({
                isLoading: false,
                performanceReport: response.getPerformancereport()
            })*/
        })
    }

    componentWillUnmount() {

    }

    render() {
        if(this.state.isLoading) {
            return null;
        }

        this.position = 0;
        return (
            <Container>

                {/*<RunSummaryCardDeck
                    position={ 1 }
                    testSummaryProfile={ this.state.performanceReport.testSummaryProfile }
                />


                <LifecycleCardDeck
                    position={ 2 }
                    activityOnCreateProfile={ this.state.performanceReport.testSummaryProfile }
                />*/}

                { this._getHeaderRow("Binder") }
                <BinderCardDeck
                    binderStats={ this.state.performanceReport.getBinderstatsList() }
                />

                { this._getHeaderRow("Memory") }
                <MemoryCardDeck
                    memoryStats={ this.state.performanceReport.getMemorystatsList() }
                />

                { this._getHeaderRow("Unix Process") }
                <UnixProcessCardDeck
                    unixProcessStatsList={ this.state.performanceReport.getUnixprocessstatsList() }
                />

                { this._getHeaderRow("Garbage Collector") }
                <GcCardDeck
                    gcStatsList={ this.state.performanceReport.getGcstatsList() }
                />

                { this._getHeaderRow("Network") }
                <NetworkCardDeck
                    networkStatsList={ this.state.performanceReport.getNetworkstatsList() }
                />

                { this._getHeaderRow("Threads") }
                <ThreadCardDeck
                    threadStatsList={ this.state.performanceReport.getThreadstatsList() }
                />

                { this._getHeaderRow("File IO") }
                <FileIoCardDeck
                    fileIoStatsList={ this.state.performanceReport.getFileiostatsList() }
                    />
            </Container>
        )
    }

    _getHeaderRow(title) {
        this.position += 1;
        console.log("fuck: " + this.position);
        return (
            <HeaderRow
                no={ this.position }
                title={ title }
            />
        )
    }
}