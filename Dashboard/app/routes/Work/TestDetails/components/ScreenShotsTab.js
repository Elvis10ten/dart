import React, { Component } from 'react';
import PropTypes from "prop-types";
import { CardColumns, Col, Container, Row } from "../../../../components";
import GalleryCard from "../../../components/Gallery/GalleryCard";

const { RemoteFile } = require("./../../../../proto/TestDetails_pb")

export default class ScreenShotsTab extends Component {

    static propTypes = {
        screenShots: PropTypes.arrayOf(PropTypes.instanceOf(RemoteFile))
    }

    render() {
        const screenShotsView = this.props.screenShots.map((screenShot) =>
            this._getScreenShotView(screenShot)
        );

        return (
            <Container>
                <Row>
                    <Col lg={12}>
                        <CardColumns>
                            { screenShotsView }
                        </CardColumns>
                    </Col>
                </Row>
            </Container>
        )
    }

    _getScreenShotView(screenShot) {
        return (
            <GalleryCard
                name={ screenShot.getName() }
                url={ screenShot.getUrl() }
            />
        )
    }
}