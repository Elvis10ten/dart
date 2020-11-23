import React, {Component} from 'react';

import PropTypes from "prop-types";
import {Card, CardGroup, Container} from "../../../components";
import OverviewCard from "../TestDetails/components/OverviewCard";

const { TestSummaryProfile } = require("./../../../proto/TestSummaryProfile_pb")

export default class RunSummaryCardDeck extends Component {

    static propTypes = {
        testSummaryProfile: PropTypes.instanceOf(TestSummaryProfile)
    }

    render() {
        const runSummary = this.props.testSummaryProfile

        return(
            <Container>
                <CardGroup className="mb-5">
                    { this._getOverviewCard("Time to App.onCreate", runSummary.timeToCallAppOnCreate) }
                    { this._getOverviewCard("Time taken by App.onCreate", runSummary.appOnCreateTime) }
                    { this._getOverviewCard("Battery temperature delta", runSummary.batteryTemperatureDelta) }
                    { this._getOverviewCard("Battery level delta", runSummary.batteryLevelDelta) }
                </CardGroup>

                <CardGroup className="mb-5">
                    { this._getOverviewCard("Time to first Activity.onCreate", runSummary.timeToFirstActivityOnCreate) }
                    { this._getOverviewCard("Time to first Activity.onStart", runSummary.timeToFirstActivityOnStart) }
                    { this._getOverviewCard("Time to first Activity.onResume", runSummary.timeToFirstActivityOnResume) }
                </CardGroup>
            </Container>
        )
    }

    _getOverviewCard(title, value) {
        return (
            <Card body>
                <OverviewCard
                    title={ title }
                    value={ value }
                />
            </Card>
        )
    }
}