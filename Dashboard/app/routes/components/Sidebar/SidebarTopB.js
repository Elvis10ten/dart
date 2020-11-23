import React from 'react';
import { Link } from 'react-router-dom';

import {
    Sidebar,
    UncontrolledTooltip
} from './../../../components';

const SidebarTopB = () => (
    <React.Fragment>
        { /* START Sidebar TOP: B */ }
            { /* START DESKTOP View */ }
            <Sidebar.HideSlim>
                <div>
                    <div className="d-flex">
                        <Link to="/" className="align-self-center sidebar__brand" id="tooltipBackToHome">
                            <i className="fa fa-send fa-fw fa-2x"></i>
                        </Link>
                        <UncontrolledTooltip placement="right" target="tooltipBackToHome">
                            Back to Home
                        </UncontrolledTooltip>
                    </div>
                </div>
            </Sidebar.HideSlim>
            { /* END DESKTOP View */ }
            { /* START SLIM Only View */ }
            <Sidebar.ShowSlim>
                <div className="text-center">
                    <Link to="/">
                        <i className="fa fa-send fa-fw text-primary" id="tooltipBackToHomeSlim"></i>
                    </Link>
                    <UncontrolledTooltip placement="right" target="tooltipBackToHomeSlim">
                        Back to Home
                    </UncontrolledTooltip>
                </div>
            </Sidebar.ShowSlim>
            { /* END SLIM Only View  */ }
        { /* END Sidebar TOP: B */ }
    </React.Fragment>
)

export { SidebarTopB };
