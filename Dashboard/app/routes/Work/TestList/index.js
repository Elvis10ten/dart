import React from 'react';
import PropTypes from 'prop-types';

import {
    Container,
    Row,
    Col, Card
} from './../../../components';

import TasksList from './TestList';
import {Breadcrumb, BreadcrumbItem, CardBody, CardTitle} from "../../../components";
import {Link} from "react-router-dom";

const TestList = (props) => (
    <React.Fragment>
        <Container>

            <Breadcrumb className="mr-auto d-flex align-items-center">

                <BreadcrumbItem active>
                    <Link to="/">
                        <i className="fa fa-home"></i>
                    </Link>
                </BreadcrumbItem>

                <BreadcrumbItem>
                    <Link to={`/work/${ props.match.params.workId } `}>
                        Work-{ props.match.params.workId }
                    </Link>
                </BreadcrumbItem>

                <BreadcrumbItem active>
                    {props.match.params.deviceName}
                </BreadcrumbItem>
            </Breadcrumb>

            <Row>

                <Col lg={ 3 }>
                    <Card className="mb-3">
                        <CardBody>
                            <CardTitle tag="h6" className="mb-4">
                                Passed
                            </CardTitle>
                            <div className="mb-3">
                                <h2 className="text-success">237</h2>
                            </div>
                        </CardBody>
                    </Card>
                </Col>

                <Col lg={ 3 }>
                    <Card className="mb-3">
                        <CardBody>
                            <CardTitle tag="h6" className="mb-4">
                                Failed
                            </CardTitle>
                            <div className="mb-3">
                                <h2 className="text-danger">20</h2>
                            </div>
                        </CardBody>
                    </Card>
                </Col>

                <Col lg={ 3 }>
                    <Card className="mb-3">
                        <CardBody>
                            <CardTitle tag="h6" className="mb-4">
                                Ignored
                            </CardTitle>
                            <div className="mb-3">
                                <h2 className="text-info-dark">5</h2>
                            </div>
                        </CardBody>
                    </Card>
                </Col>

                <Col lg={ 3 }>
                    <Card className="mb-3">
                        <CardBody>
                            <CardTitle tag="h6" className="mb-4">
                                Duration
                            </CardTitle>
                            <div className="mb-3">
                                <h2 className="text-info">29m:36s</h2>
                            </div>
                        </CardBody>
                    </Card>
                </Col>

                <Col lg={ 12 }>

                    <TasksList />
                </Col>
            </Row>
        </Container>
    </React.Fragment>
);

TestList.propTypes = {
    match: PropTypes.object.isRequired
};
export default TestList;