import React from 'react';
import faker from 'faker/locale/en_US';
import {Link} from 'react-router-dom';

import {
    Container,
    Row,
    Col,
    CardHeader,
    DropdownToggle,
    DropdownItem,
    DropdownMenu,
    UncontrolledButtonDropdown,
    Card,
    ButtonGroup,
    Button,
    CardBody,
    CardFooter,
    CardGroup,
    Table,
    TabPane,
    Badge,
    Nav,
    NavItem,
    UncontrolledTabs, InputGroupAddon
} from './../../../components';

import {Profile} from "../../components/Profile";
import {ProfileOverviewCard} from "../../components/Profile/ProfileOverviewCard";
import {DlRowContacts} from "../../components/Profile/DlRowContacts";
import {DlRowAddress} from "../../components/Profile/DlRowAddress";
import {ChatLeft} from "../../components/Chat/ChatLeft";
import {ChatRight} from "../../components/Chat/ChatRight";
import {ChatCardFooter} from "../../components/Chat/ChatCardFooter";
import {TrTableMessages} from "./components/TrTableMessages";
import {TimelineDefault} from "../../components/Timeline/TimelineDefault";
import {
    Breadcrumb,
    BreadcrumbItem,
    ButtonToolbar,
    CardColumns, Input,
    InputGroup,
    UncontrolledTooltip
} from "../../../components";
import PropTypes from "prop-types";
import TestList from "../TestList";
import {ProjectsSmHeader} from "../../components/Projects/ProjectsSmHeader";
import {GalleryCard} from "../../components/Gallery/GalleryCard";
import {Paginations} from "../../components/Paginations";
import {HeaderMain} from "../../components/HeaderMain";
import ReCharts from "../../Graphs/ReCharts/ReCharts";
import {Attachment} from "../../components/Attachment";
import { TestDetailsMessage } from "./../../../proto/TestDetails_pb"
import BreadCrumbs, { BreadCrumbItemInfo} from "../components/BreadCrumbs"
import ScreenVideoCard from "./components/ScreenVideoCard";
import ScreenShotsTab from "./components/ScreenShotsTab";
import ArtifactsTab from "./components/ArtifactsTab";
import PerformanceTab from "./components/PerformanceTab";

const { Artifact } = require("./../../../proto/Artifact_pb")

const items = [
    new BreadCrumbItemInfo("Work-Abacus", "/work/1", false),
    new BreadCrumbItemInfo("Samsung s9", "/work/1/sam/tests", false),
    new BreadCrumbItemInfo("Test#1", "/work/1/sam/1", true)
]

const video = new Artifact();
video.setUrl("http://localhost:8000/demo_clear.mp4")

const screenShot1 = new Artifact();
screenShot1.setUrl("http://localhost:8000/1.webp")
screenShot1.setName("ScreenShot#1")
const screenShot2 = new Artifact();
screenShot2.setUrl("http://localhost:8000/4.webp")
screenShot2.setName("ScreenShot#2")
const screenShot3 = new Artifact();
screenShot3.setUrl("http://localhost:8000/9.webp")
screenShot3.setName("ScreenShot#3")

screenShot1.setType("log")
screenShot2.setType("image")
screenShot3.setType("file")

screenShot1.setSizebytes(1024 * 1024 * 1)
screenShot2.setSizebytes(1024 * 1024 * 2)
screenShot3.setSizebytes(1024 * 1024 * 3)

const screenshots = [
    screenShot1,
    screenShot2,
    screenShot3
]

const artifacts = screenshots


const videoPositionChangeCallback = (newPosition) => {
    console.log("Video: " + newPosition)
}

const TestDetails = (props) => (
    <React.Fragment>
        <Container>

            <BreadCrumbs
                itemsInfo={ items }
                />

            { /* START Content */}
            <Row>
                <ScreenVideoCard
                    videoFile={ video }
                    //deviceProps={ deviceProps }
                    onPositionChanged={ videoPositionChangeCallback }
                />

                <Col lg={8}>
                    <UncontrolledTabs initialActiveTabId="timeline">
                        { /* START Pills Nav */}
                        <Nav pills className="mb-4 flex-column flex-md-row mt-4 mt-lg-0">

                            <NavItem>
                                <UncontrolledTabs.NavLink tabId="timeline">
                                    Timeline
                                </UncontrolledTabs.NavLink>
                            </NavItem>

                            <NavItem>
                                <UncontrolledTabs.NavLink tabId="screenshots">
                                    Screenshots
                                </UncontrolledTabs.NavLink>
                            </NavItem>

                            <NavItem>
                                <UncontrolledTabs.NavLink tabId="performance">
                                    Performance
                                </UncontrolledTabs.NavLink>
                            </NavItem>

                            <NavItem>
                                <UncontrolledTabs.NavLink tabId="artifacts">
                                    Artifacts
                                    <Badge pill color="secondary" className="ml-2">
                                        { artifacts.length }
                                    </Badge>
                                </UncontrolledTabs.NavLink>
                            </NavItem>
                        </Nav>
                        { /* END Pills Nav */}

                        <UncontrolledTabs.TabContent>
                            <TabPane tabId="timeline">
                                <CardGroup className="mb-5">

                                    <Card body>
                                        <ProfileOverviewCard
                                            title="Duration"
                                            value="1m:30s"
                                            footerTitle="Last Month"
                                            footerTitleClassName="text-danger"
                                            footerIcon="caret-up"
                                            footerValue="23%"
                                        />
                                    </Card>

                                    <Card body>
                                        <ProfileOverviewCard
                                            title="Status"
                                            value="Success"
                                            footerTitle="Retries"
                                            footerTitleClassName="text-success"
                                            footerIcon="check"
                                            footerValue="0"
                                        />
                                    </Card>

                                    <Card body>
                                        <ProfileOverviewCard
                                            title="Cost"
                                            value="$0.01"
                                            footerTitle="Last Month"
                                            footerTitleClassName="text-success"
                                            footerIcon="caret-down"
                                            footerValue="-5%"
                                        />
                                    </Card>

                                </CardGroup>

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

                            </TabPane>

                            <TabPane tabId="screenshots">

                                <ScreenShotsTab
                                    screenShots={ screenshots }
                                    />

                            </TabPane>

                            <TabPane tabId="performance">
                                <PerformanceTab
                                />
                                <ReCharts
                                />
                            </TabPane>

                            <TabPane tabId="artifacts">
                                <ArtifactsTab
                                    artifacts={ artifacts }
                                    />
                            </TabPane>

                        </UncontrolledTabs.TabContent>
                    </UncontrolledTabs>
                </Col>
            </Row>
            { /* END Content */}

        </Container>
    </React.Fragment>
);

TestDetails.propTypes = {
    match: PropTypes.object.isRequired
};

export default TestDetails;