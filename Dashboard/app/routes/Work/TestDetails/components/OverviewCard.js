import React from 'react';
import PropTypes from 'prop-types';

import { 
    CardTitle
} from './../../../../components';

const OverviewCard = (props) => (
    <React.Fragment>
        <div className="d-flex">
            <CardTitle tag="h6">
                { props.title }
            </CardTitle>
        </div>
        <div className="text-center my-4">
            <h2>{ props.value }</h2>
        </div>
        {/*<div className="d-flex">
            <span>
                { props.footerTitle }
            </span>
            <span className={ `ml-auto ${ props.footerTitleClassName }` }>
                <i className={ `fa mr-1 fa-${ props.footerIcon }` }></i>
                { props.footerValue }
            </span>
        </div>*/}
    </React.Fragment>
)
OverviewCard.propTypes = {
    title: PropTypes.node,
    value: PropTypes.node,
    /*footerTitle: PropTypes.node,
    footerTitleClassName: PropTypes.node,
    footerIcon: PropTypes.node,
    footerValue: PropTypes.node*/
};

export default OverviewCard;
