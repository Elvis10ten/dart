import React, {Component} from 'react';
import PropTypes from "prop-types";
import {Breadcrumb, BreadcrumbItem} from "../../../components";
import {Link} from "react-router-dom";

export default class BreadCrumbs extends Component {

    static propTypes = {
        itemsInfo: PropTypes.arrayOf(PropTypes.instanceOf(BreadCrumbItemInfo))
    }

    constructor(props) {
        super(props);
    }

    render() {
        const breadCrumbItems = this.props.itemsInfo.map((itemInfo) =>
            this._getBreadCrumbItem(itemInfo)
        );

        return (
            <Breadcrumb className="mr-auto d-flex align-items-center">

                <BreadcrumbItem active>
                    <Link to="/">
                        <i className="fa fa-home"></i>
                    </Link>
                </BreadcrumbItem>

                { breadCrumbItems }
            </Breadcrumb>
        )
    }

    _getBreadCrumbItem(navItem) {
        if (navItem.isActive) {
            return (
                <BreadcrumbItem active>
                    { navItem.title }
                </BreadcrumbItem>
            )
        } else {
            return (
                <BreadcrumbItem>
                    <Link to={ navItem.path }>{ navItem.title }</Link>
                </BreadcrumbItem>
            )
        }
    }
}

export function BreadCrumbItemInfo(title, path, isActive) {
    this.title = title;
    this.path = path;
    this.isActive = isActive;
}