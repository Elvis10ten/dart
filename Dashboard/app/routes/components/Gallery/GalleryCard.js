import React from 'react';
import PropTypes from 'prop-types';

import { 
    Card,
    CardImg,
    Media,
    CardBody
} from './../../../components';

const GalleryCard = (props) => (
    <React.Fragment>
        <Card className="mb-3">

            <CardImg
                top
                width="100%"
                src={ props.url }
                alt={ props.name }
            />

            <CardBody>
                <Media className="mb-3">

                    <Media body>
                        <span>
                            <a className="h6 text-decoration-none" href="#">
                                { props.name }
                            </a>
                        </span>
                    </Media>

                    <Media right>
                        <a
                            href={ props.url }
                            className="ml-auto"
                            download={ props.name }
                        >
                            <i className="fa fa-download"></i>
                        </a>
                    </Media>

                </Media>
            </CardBody>
        </Card>
    </React.Fragment>
)

GalleryCard.propTypes = {
    name: PropTypes.string,
    url: PropTypes.string
};

export default GalleryCard;
