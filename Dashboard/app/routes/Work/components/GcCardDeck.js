import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import { Container } from "../../../components";
import SimpleBarChartCard from "./SimpleBarChartCard";
import StackedAreaChartCard, {AreaVariable} from "./StackedAreaChartCard";
import SimpleLineChartCard, {SimpleLineVariable} from "./SimpleLineChartCard";
import {bytesToKilobytes} from "./StatsUtils";

const { GcStats } = require("./../../../proto/GcStats_pb")

export default class GcCardDeck extends Component {

    static propTypes = {
        gcStatsList: PropTypes.arrayOf(PropTypes.instanceOf(GcStats))
    }

    _formatRunCountStats(gcStats, lastGcStats) {
        return ({
            nonBlocking: gcStats.getRuncount() - lastGcStats.getRuncount(),
            blocking: gcStats.getBlockingruncount() - lastGcStats.getBlockingruncount(),
            time: (gcStats.getRelativetime() / 1000)
        })
    }

    _formatBytesAllocationStats(gcStats, lastGcStats) {
        return ({
            allocated: bytesToKilobytes(gcStats.getTotalbytesallocated() - lastGcStats.getTotalbytesallocated()),
            freed: bytesToKilobytes(gcStats.getTotalbytesfreed() - lastGcStats.getTotalbytesfreed()),
            time: (gcStats.getRelativetime() / 1000)
        })
    }

    _formatTotalDurationStats(gcStats, lastGcStats) {
        return ({
            nonBlocking: (gcStats.getRuntotalduration() - lastGcStats.getRuntotalduration()) / 1000,
            blocking: (gcStats.getBlockingruntotalduration() - lastGcStats.getBlockingruntotalduration()) / 1000,
            time: (gcStats.getRelativetime() / 1000)
        })
    }

    render() {
        const runCountStatsList = [];
        const bytesAllocationStatsList = [];
        const totalDurationStatsList = [];

        let lastGcStats = this.props.gcStatsList[0];
        this.props.gcStatsList.map((gcStats) => {
            runCountStatsList.push(this._formatRunCountStats(gcStats, lastGcStats));
            bytesAllocationStatsList.push(this._formatBytesAllocationStats(gcStats, lastGcStats));
            totalDurationStatsList.push(this._formatTotalDurationStats(gcStats, lastGcStats));
            lastGcStats = gcStats
        })

        return (
            <Container>
                <SimpleLineChartCard
                    items={ bytesAllocationStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variablesUnit="kb"
                    variables={[
                        new SimpleLineVariable("allocated", colors['warning'], colors['warning-03']),
                        new SimpleLineVariable("freed", colors['success'], colors['success-03'])
                    ]}
                    title="Allocation"
                    subtitle="Bytes allocated and freed"
                />

                <StackedAreaChartCard
                    items={ runCountStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("nonBlocking", colors['success'], colors['success-03']),
                        new AreaVariable("blocking", colors['warning'], colors['warning-03'])
                    ]}
                    title="GC runs"
                    subtitle="Number of times GC ran"
                />

                <StackedAreaChartCard
                    items={ totalDurationStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variablesUnit="s"
                    variables={[
                        new AreaVariable("nonBlocking", colors['success'], colors['success-03']),
                        new AreaVariable("blocking", colors['warning'], colors['warning-03'])
                    ]}
                    title="Total duration"
                    subtitle="For GC runs"
                />
            </Container>
        )
    }
}