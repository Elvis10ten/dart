import React from 'react';
import { Link } from 'react-router-dom';

import {
    Navbar,
    Nav,
    NavItem,
    SidebarTrigger, NavbarThemeProvider, Avatar, AvatarAddOn
} from './../../components';

import { NavbarActivityFeed } from './NavbarActivityFeed';
import { NavbarMessages } from './NavbarMessages';
import { NavbarUser } from './NavbarUser';
import { LogoThemed } from './../../routes/components/LogoThemed/LogoThemed';
import {
    Button,
    DropdownToggle,
    NavbarBrand,
    NavbarToggler,
    NavLink,
    UncontrolledCollapse,
    UncontrolledDropdown
} from "../../components";
import {NavbarNavigation} from "../../routes/components/Navbars/NavbarNavigation";
import {randomAvatar} from "../../utilities";
import {DropdownProfile} from "../../routes/components/Dropdowns/DropdownProfile";
import PropTypes from "prop-types";
import {NavbarExample} from "../../routes/components/Navbars/NavbarExample";

const DefaultNavbar = ({ themeColor, themeStyle, navStyle }) => {
    return (
        <NavbarThemeProvider style={ themeStyle } color={ themeColor } className="shadow-sm">
            <Navbar expand="xs" themed fluid>
                <Nav pills>
                    <NavItem className="mr-3">
                        <SidebarTrigger/>
                    </NavItem>
                </Nav>

                <Nav pills>
                    <NavItem>
                        <NavLink tag={ NavbarToggler } id="navbar-navigation-toggler" className="b-0">
                            <i className="fa fa-fw fa-bars"></i>
                        </NavLink>
                    </NavItem>
                </Nav>

                { /* Navigation with Collapse */ }
                <UncontrolledCollapse navbar toggler="#navbar-navigation-toggler">
                    <NavbarNavigation
                        pills={ navStyle === 'pills' }
                        accent={ navStyle === 'accent' }
                    />
                </UncontrolledCollapse>

                { /* END Navbar: Left Side */ }
                { /* START Navbar: Right Side */ }
                <Nav className="ml-auto" pills>
                    <NavbarMessages />
                    <NavbarActivityFeed />
                    { /* START Navbar: Dropdown */ }
                    <UncontrolledDropdown nav inNavbar>
                        <DropdownToggle nav>
                            <Avatar.Image
                                size="sm"
                                src={ randomAvatar() }
                                addOns={[
                                    <AvatarAddOn.Icon
                                        className="fa fa-circle"
                                        color="white"
                                        key="avatar-icon-bg"
                                    />,
                                    <AvatarAddOn.Icon
                                        className="fa fa-circle"
                                        color="danger"
                                        key="avatar-icon-fg"
                                    />
                                ]}
                            />
                        </DropdownToggle>
                        <DropdownProfile
                            right
                        />
                    </UncontrolledDropdown>
                    { /* END Navbar: Dropdown */ }
                    <NavbarUser className="d-none d-lg-block" />
                </Nav>
                { /* END Navbar: Right Side */ }
            </Navbar>
        </NavbarThemeProvider>
    );
}

DefaultNavbar.propTypes = {
    navStyle: PropTypes.oneOf(['pills', 'accent', 'default']),
    themeStyle: PropTypes.string,
    themeColor: PropTypes.string,
};
DefaultNavbar.defaultProps = {
    navStyle: 'default',
    themeStyle: 'dark',
    themeColor: 'primary'
};

export { DefaultNavbar };