import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import { Container } from "../../../components";
import SimpleBarChartCard from "./SimpleBarChartCard";
import StackedAreaChartCard, {AreaVariable} from "./StackedAreaChartCard";

const { BinderStats } = require("./../../../proto/BinderStats_pb")

export default class BinderCardDeck extends Component {

    static propTypes = {
        binderStats: PropTypes.arrayOf(PropTypes.instanceOf(BinderStats))
    }

    _prepareBinderObjectStats(binderStats) {
        return ({
            death: binderStats.getDeathobjectcount(),
            local: binderStats.getLocalobjectcount(),
            proxy: binderStats.getProxyobjectcount(),
            time: (binderStats.getRelativetime() / 1000)
        })
    }

    _prepareBinderTransactionStats(binderStats) {
        return ({
            received: binderStats.getReceivedtransactions(),
            sent: binderStats.getSenttransactions(),
            time: (binderStats.getRelativetime() / 1000)
        })
    }

    render() {
        const binderObjectsStatsList = this.props.binderStats.map((binderStats) =>
            this._prepareBinderObjectStats(binderStats)
        )

        const binderTransactionsStatsList = this.props.binderStats.map((binderStats) =>
            this._prepareBinderTransactionStats(binderStats)
        )

        return (
            <Container>
                <StackedAreaChartCard
                    items={ binderObjectsStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("death", colors['primary'], colors['primary-03']),
                        new AreaVariable("local", colors['purple'], colors['purple-03']),
                        new AreaVariable("proxy", colors['success'], colors['success-03'])
                    ]}
                    title="Binder objects"
                    subtitle="Binder objects created over time"
                />

                <StackedAreaChartCard
                    items={ binderTransactionsStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new AreaVariable("received", colors['primary'], colors['primary-03']),
                        new AreaVariable("sent", colors['purple'], colors['purple-03'])
                    ]}
                    title="Binder transactions"
                    subtitle="Binder transactions over time"
                />
            </Container>
        )
    }
}