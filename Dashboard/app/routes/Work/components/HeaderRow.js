import React from 'react';
import PropTypes from 'prop-types';
import { Media } from 'reactstrap';
import {Col, Row} from "../../../components";

const HeaderRow = (props) => (
    <Row>
        <Col lg={ 12 }>
            <Media className={ `mb-3 ${ props.className }` }>
                <Media left top>
                    <h1 className="mr-3 display-4 text-muted">
                        {props.no}.
                    </h1>
                </Media>
                <Media body>
                    <br/>
                    <h4 className="mt-1">
                        {props.title}
                    </h4>
                </Media>
            </Media>
        </Col>
    </Row>
)

HeaderRow.propTypes = {
    no: PropTypes.oneOfType([
        PropTypes.string,
        PropTypes.number
    ]),
    title: PropTypes.string,
    className: PropTypes.string
};

export { HeaderRow };
