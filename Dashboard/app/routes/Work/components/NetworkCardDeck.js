import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import { Container } from "../../../components";
import SimpleBarChartCard from "./SimpleBarChartCard";
import StackedAreaChartCard, {AreaVariable} from "./StackedAreaChartCard";
import SimpleLineChartCard, {SimpleLineVariable} from "./SimpleLineChartCard";
import {bytesToKilobytes} from "./StatsUtils";

const { NetworkStats } = require("./../../../proto/NetworkStats_pb")

export default class NetworkCardDeck extends Component {

    static propTypes = {
        networkStatsList: PropTypes.arrayOf(PropTypes.instanceOf(NetworkStats))
    }

    _formatPacketStats(networkStats, lastNetworkStats) {
        return ({
            rx: networkStats.getRxpackets() - lastNetworkStats.getRxpackets(),
            tx: networkStats.getTxpackets() - lastNetworkStats.getTxpackets(),
            time: (networkStats.getRelativetime() / 1000)
        })
    }

    _formatBytesStats(networkStats, lastNetworkStats) {
        return ({
            rx: bytesToKilobytes(networkStats.getRxbytes() - lastNetworkStats.getRxbytes()),
            tx: bytesToKilobytes(networkStats.getTxbytes() - lastNetworkStats.getTxbytes()),
            time: (networkStats.getRelativetime() / 1000)
        })
    }

    render() {
        const packetStatsList = [];
        const bytesStatsList = [];

        let lastNetworkStats = this.props.networkStatsList[0];
        this.props.networkStatsList.map((networkStats) => {
            packetStatsList.push(this._formatPacketStats(networkStats, lastNetworkStats));
            bytesStatsList.push(this._formatBytesStats(networkStats, lastNetworkStats));
            lastNetworkStats = networkStats;
        })

        return (
            <Container>
                <StackedAreaChartCard
                    items={ bytesStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variablesUnit="kb"
                    variables={[
                        new AreaVariable("rx", colors['primary'], colors['primary-03']),
                        new AreaVariable("tx", colors['purple'], colors['purple-03'])
                    ]}
                    title="Network Bytes"
                    subtitle="TODO"
                />

                <StackedAreaChartCard
                    items={ packetStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("rx", colors['primary'], colors['primary-03']),
                        new AreaVariable("tx", colors['purple'], colors['purple-03'])
                    ]}
                    title="Network packets"
                    subtitle="TODO"
                />
            </Container>
        )
    }
}