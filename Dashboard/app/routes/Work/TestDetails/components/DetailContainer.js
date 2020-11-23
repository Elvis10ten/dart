import React, {Component} from 'react';
import PropTypes from "prop-types";
import { TestDetails } from "./../../../proto/TestDetails_pb"
import {Breadcrumb, BreadcrumbItem} from "../../../../components";
import {Link} from "react-router-dom";
import BreadCrumbs, { BreadCrumbItemInfo } from "../../components/BreadCrumbs";

import {
    Container,
    Card,
    CardFooter,
    CardHeader,
    Input,
    InputGroup,
} from './../../../../components';

export default class DetailContainer extends Component {

    static propTypes = {
        workKey: PropTypes.string,
        deviceKey: PropTypes.string,
        deviceModel: PropTypes.string,
        testKey: PropTypes.string,
        testDisplayName: PropTypes.string
    }

    constructor(props) {
        super(props);

        const workPath = "/work/" + this.props.workKey
        const workDevicePath = workPath + "/" + this.props.deviceKey

        this.state = {
            isLoading: true,
            breadCrumbItemsInfo: [
                new BreadCrumbItemInfo("Work-" + this.props.workKey, workPath, false),
                new BreadCrumbItemInfo(this.props.deviceModel, workDevicePath, false),
                new BreadCrumbItemInfo(this.props.testDisplayName, null, true),
            ],
            testDetails: null
        };
    }

    componentDidMount() {
    }

    componentWillUnmount() {

    }

    _getLoadedView() {
        return (
            <Container>

            </Container>
        )
    }

    _getLoadingView() {
        return (
            <Container>
                <BreadCrumbs
                    itemsInfo={ this.state.breadCrumbItemsInfo }
                />

                Loading..
            </Container>
        )
    }
}