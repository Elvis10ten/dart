import React from 'react';
import faker from 'faker/locale/en_US';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

import { 
    Badge,
    Avatar,
    CustomInput,
    UncontrolledButtonDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    AvatarAddOn
} from './../../../../components';

import { randomArray, randomAvatar } from './../../../../utilities';

const badges = [
    "secondary"
];

const avatarStatus = [
    "secondary",
    "warning",
    "danger",
    "success"
];

const testStatus = [
        <React.Fragment key="1">
            <span className="badge badge-success">Passed</span>
        </React.Fragment>,
        <React.Fragment key="2">
            <span className="badge badge-danger">Failed</span>
        </React.Fragment>,
        <React.Fragment key="3">
            <span className="badge badge-dark">Ignored</span>
        </React.Fragment>,
        <React.Fragment key="3">
            <span className="badge badge-danger">Error</span>
        </React.Fragment>
];

const TrTableTasksList = (props) => (
    <React.Fragment>
        <tr>

            <td className="align-middle">
                #{ props.id }
            </td>

            <td className="align-middle">
                { randomArray(testStatus) }
            </td>

            <td className="align-middle">
                <div>
                    <Link to={`/work/${ props.workId }/${ props.deviceName }/test/${ props.id } `} className="text-decoration-none">
                        <h6>Full Test Display Name</h6>
                    </Link>
                </div>

                <p className="mb-0">
                    <span className="mr-2">
                        TestClass#TestMethod()
                    </span>
                </p>
            </td>

            <td className="align-middle">
                2m:59s
            </td>
            <td className="align-middle text-right">
                <UncontrolledButtonDropdown className="align-self-center ml-auto">
                    <DropdownToggle color="link" size="sm">
                        <i className="fa fa-gear" /><i className="fa fa-angle-down ml-2" />
                    </DropdownToggle>
                    <DropdownMenu right>
                        <DropdownItem>
                            <i className="fa fa-fw fa-folder-open mr-2"></i>
                            View
                        </DropdownItem>
                        <DropdownItem>
                            <i className="fa fa-fw fa-ticket mr-2"></i>
                            Add Task
                        </DropdownItem>
                    </DropdownMenu>
                </UncontrolledButtonDropdown>
            </td>
        </tr>
    </React.Fragment>
)

TrTableTasksList.propTypes = {
    id: PropTypes.node,
    workId: PropTypes.node,
    deviceName: PropTypes.node
};

export { TrTableTasksList };
