import React from 'react';
import PropTypes from 'prop-types';
import faker from 'faker/locale/en_US';
import { 
    Media, 
    Button 
} from 'reactstrap';

const Attachment = (props) => (
        <Media className={ `${ props.mediaClassName }` }>

            <Media left className="mr-2">
                <span className="fa-stack fa-lg">
                    <i className={ `fa fa-square fa-stack-2x fa-${ props.bgIcon } fa-stack-1x ${ props.bgIconClassName }` }></i>
                    <i className={ `fa fa-${ props.icon } fa-stack-1x ${ props.iconClassName }` }></i>
                </span>
            </Media>

            <Media body className="d-flex flex-column flex-md-row">
                <div>
                    <div className="text-inverse text-truncate">
                        { props.name }
                    </div>
                    <span>
                        <span>
                            { props.formattedSize }
                        </span>
                    </span>
                </div>
                <div className="ml-md-auto flex-row-reverse flex-md-row d-flex justify-content-end mt-2 mt-md-0">
                    <a
                        href={ props.downloadUrl }
                        className="btn align-self-center mr-2 mr-md-0">
                        <i className="fa fa-fw fa-download"></i>
                    </a>
                </div>
            </Media>
        </Media>


)
Attachment.propTypes = {
    name: PropTypes.string,
    formattedSize: PropTypes.string,
    downloadUrl: PropTypes.string,
    mediaClassName: PropTypes.string,
    icon: PropTypes.string,
    iconClassName: PropTypes.string,
    bgIcon: PropTypes.string,
    bgIconClassName: PropTypes.string
};

Attachment.defaultProps = {
    mediaClassName: "",
    iconClassName: "text-white",
    bgIcon: "square",
    bgIconClassName: "text-muted"
};

export { Attachment };
