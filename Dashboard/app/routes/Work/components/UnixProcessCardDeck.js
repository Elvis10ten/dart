import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import { Container } from "../../../components";
import StackedAreaChartCard, {AreaVariable} from "./StackedAreaChartCard";
import SimpleLineChartCard, {SimpleLineVariable} from "./SimpleLineChartCard";

const { UnixProcessStats } = require("./../../../proto/UnixProcessStats_pb")

export default class UnixProcessCardDeck extends Component {

    static propTypes = {
        unixProcessStatsList: PropTypes.arrayOf(PropTypes.instanceOf(UnixProcessStats))
    }

    _formatFaultStat(unixProcessStats, lastUnixProcessStats) {
        return ({
            minor: unixProcessStats.getNumminorfaults() - lastUnixProcessStats.getNumminorfaults(),
            childMinor: unixProcessStats.getNumchildminorfaults() - lastUnixProcessStats.getNumchildminorfaults(),
            major: unixProcessStats.getNummajorfaults() - lastUnixProcessStats.getNummajorfaults(),
            childMajor: unixProcessStats.getNumchildmajorfaults() - lastUnixProcessStats.getNumchildmajorfaults(),
            time: (unixProcessStats.getRelativetime() / 1000)
        })
    }

    _formatCpuTimeStats(unixProcessStats, lastUnixProcessStats) {
        return ({
            user: unixProcessStats.getUsertime() - lastUnixProcessStats.getUsertime(),
            system: unixProcessStats.getSystemtime() - lastUnixProcessStats.getSystemtime(),
            childUser: unixProcessStats.getChildusertime() - lastUnixProcessStats.getChildusertime(),
            childSystem: unixProcessStats.getChildsystemtime() - lastUnixProcessStats.getChildsystemtime(),
            time: (unixProcessStats.getRelativetime() / 1000)
        })
    }

    _formatAggregatedBlockIoDelaysStats(unixProcessStats, lastUnixProcessStats) {
        return ({
            delays: unixProcessStats.getAggregatedblockiodelaysinticks() - lastUnixProcessStats.getAggregatedblockiodelaysinticks(),
            time: (unixProcessStats.getRelativetime() / 1000)
        })
    }

    render() {
        const faultStatsList = [];
        const cpuTimeStatsList = [];
        const aggregatedBlockIoDelaysStatsList = [];

        let lastUnixProcessStats = this.props.unixProcessStatsList[0];
        this.props.unixProcessStatsList.map((unixProcessStats) => {
            faultStatsList.push(this._formatFaultStat(unixProcessStats, lastUnixProcessStats));
            cpuTimeStatsList.push(this._formatCpuTimeStats(unixProcessStats, lastUnixProcessStats));
            aggregatedBlockIoDelaysStatsList.push(this._formatAggregatedBlockIoDelaysStats(unixProcessStats, lastUnixProcessStats));
            lastUnixProcessStats = unixProcessStats;
        })

        return (
            <Container>
                <StackedAreaChartCard
                    items={ cpuTimeStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("user", colors['primary'], colors['primary-03']),
                        new AreaVariable("system", colors['info'], colors['info-03']),
                        new AreaVariable("childUser", colors['yellow'], colors['yellow-03']),
                        new AreaVariable("childSystem", colors['purple'], colors['purple-03'])
                    ]}
                    title="CPU times"
                    subtitle="Cpu times by process in clock ticks"
                    />

                <StackedAreaChartCard
                    items={ faultStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("minor", colors['primary'], colors['primary-03']),
                        new AreaVariable("childMinor", colors['info'], colors['info-03']),
                        new AreaVariable("major", colors['yellow'], colors['yellow-03']),
                        new AreaVariable("childMajor", colors['purple'], colors['purple-03'])
                    ]}
                    title="Process faults"
                    subtitle="Faults by process"
                />

                <SimpleLineChartCard
                    items={ aggregatedBlockIoDelaysStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new SimpleLineVariable("delays", colors['primary'], colors['primary-03'])
                    ]}
                    title="Aggregated block IO delays"
                    subtitle="Aggregated block I/O delays, measured in clock ticks (centiseconds)."
                />
            </Container>
        )
    }
}