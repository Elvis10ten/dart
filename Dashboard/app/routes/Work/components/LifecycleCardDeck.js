import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import { Container } from "../../../components";
import SimpleBarChartCard, {SimpleBarVariable} from "./SimpleBarChartCard";

const { LifecycleProfile } = require("./../../../proto/TestSummaryProfile_pb")

export default class LifecycleCardDeck extends Component {

    static propTypes = {
        activityOnCreateProfile: PropTypes.instanceOf(LifecycleProfile)
    }

    render() {
        return (
            <Container>
                <SimpleBarChartCard
                    items={ this.props.activityOnCreateProfile }
                    individualsKey="name"
                    variables={[
                        new SimpleBarVariable("timeTaken", colors['primary'])
                    ]}
                    title="Activity.onCreate Times"
                    subtitle="Time taken by activities onCreate method"
                />
            </Container>
        )
    }
}