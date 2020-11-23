import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import {Col, Container, Row} from "../../../components";
import SimpleBarChartCard from "./SimpleBarChartCard";
import {AreaVariable} from "./StackedAreaChartCard";
import SimpleLineChartCard, {SimpleLineVariable} from "./SimpleLineChartCard";
import {bytesToKilobytes, bytesToMegabytes} from "./StatsUtils";
import {HeaderDemo} from "../../components/HeaderDemo";
import {HeaderRow} from "./HeaderRow";

const { MemoryStats } = require("./../../../proto/MemoryStats_pb")

export default class MemoryCardDeck extends Component {

    static propTypes = {
        memoryStats: PropTypes.instanceOf(MemoryStats)
    }

    _prepareSystemMemoryStats(memoryStats) {
        return ({
            available: bytesToMegabytes(memoryStats.getSystemavailablesizebytes()),
            total: bytesToMegabytes(memoryStats.getSystemtotalsizebytes()),
            threshold: bytesToMegabytes(memoryStats.getSystemthresholdsizebytes()),
            time: (memoryStats.getRelativetime() / 1000)
        })
    }

    render() {
        const systemMemoryStatsList = this.props.memoryStats.map((memoryStats) =>
            this._prepareSystemMemoryStats(memoryStats)
        )

        return (
            <Container>
                <SimpleLineChartCard
                    items={ systemMemoryStatsList }
                    individualsKey="time"
                    variablesUnit="Mb"
                    individualsUnit="s"
                    variables={[
                        new SimpleLineVariable("available", colors['success'], colors['success-03']),
                        new SimpleLineVariable("total", colors['primary'], colors['primary-03']),
                        new SimpleLineVariable("threshold", colors['purple'], colors['purple-03'])
                    ]}
                    title="System Memory"
                    subtitle="Overall system memory"
                    />
            </Container>
        )
    }
}