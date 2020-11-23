import React, { Component } from 'react';
import PropTypes from "prop-types";
import {Card, CardColumns, CardGroup, Col, Container, Row, TabPane} from "../../../../components";
import GalleryCard from "../../../components/Gallery/GalleryCard";
import {ProfileOverviewCard} from "../../../components/Profile/ProfileOverviewCard";
import {TimelineDefault} from "../../../components/Timeline/TimelineDefault";
import OverviewCard from "./OverviewCard";

const { AtomicResult } = require("./../../../../proto/AtomicResult_pb")

const a = new AtomicResult()
a.getTimestarted()
export default class TimelineTab extends Component {

    static propTypes = {
        formattedCost: PropTypes.string,
        result: PropTypes.instanceOf(AtomicResult),
        workKey: PropTypes.string,
        deviceKey: PropTypes.string
    }

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            timelineSections: null
        }
    }

    componentDidMount() {
    }

    componentWillUnmount() {

    }

    render() {
        return (
            <Container>
                { this._getOverviewCards() }

                <TimelineDefault
                    showPillDate
                    pillDate="16:30:01"
                    smallIconColor="success"
                    iconCircleColor="success"
                    iconCircle="check"
                />
                <TimelineDefault
                    showPillDate
                    pillDate="16:30:05"
                    smallIconColor="info"
                    iconCircleColor="info"
                    iconCircle="check"
                />
                <TimelineDefault
                    showPillDate
                    pillDate="2 Days ago"
                    smallIconColor="primary"
                    iconCircleColor="primary"
                    iconCircle="envelope"
                />
                <TimelineDefault
                    showPillDate
                    pillDate="3 Months ago"
                    smallIconColor="warning"
                    iconCircleColor="warning"
                    iconCircle="clock-o"
                />
                <TimelineDefault
                    showPillDate
                    pillDate="Year ago"
                    smallIconColor="success"
                    iconCircleColor="success"
                    iconCircle="check"
                />
                <TimelineDefault
                    iconCircle="close"
                />
            </Container>
        )
    }

    _getOverviewCards() {
        const testDuration = this.props.result.getTimefinished() - this.props.results.getTimestarted()
        return(
            <CardGroup className="mb-5">
                { this._getOverviewCard("Duration", testDuration) }
                { this._getOverviewCard("Status", this.props.result.getStatus()) }
                { this._getOverviewCard("Cost", this.props.formattedCost) }
            </CardGroup>
        )
    }

    _getOverviewCard(title, value) {
        return (
            <Card body>
                <OverviewCard
                    title={ title}
                    value={ value}
                />
            </Card>
        )
    }

    _getScreenShotView(screenShot) {
        return (
            <GalleryCard
                name={ screenShot.getName() }
                url={ screenShot.getDownloadurl() }
            />
        )
    }
}