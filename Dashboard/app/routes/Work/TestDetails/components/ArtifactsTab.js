import React, { Component } from 'react';
import PropTypes from "prop-types";
import {Card, CardBody} from "../../../../components";
import {Attachment} from "../../../components/Attachment";

const { RemoteFile } = require("./../../../../proto/TestDetails_pb")

export default class ArtifactsTab extends Component {

    static propTypes = {
        artifacts: PropTypes.arrayOf(PropTypes.instanceOf(RemoteFile))
    }

    render() {
        const artifactsView = this.props.artifacts.map((artifact) =>
            this._getArtifactView(artifact)
        );

        return (
            <Card className="mb-3">
                <CardBody>
                    <div>
                        { artifactsView }
                    </div>

                </CardBody>
            </Card>
        )
    }

    _getArtifactView(artifact) {
        return (
            <Attachment
                bgIconClassName={ this._getArtifactIconColor(artifact.getType()) }
                icon={ this._getArtifactIcon(artifact.getType()) }
                mediaClassName="mb-3"
                name={ artifact.getName() }
                formattedSize={ this._formatBytes(artifact.getSizebytes()) }
                downloadUrl={ artifact.getUrl() }
            />
        )
    }

    _getArtifactIcon(type) {
        switch (type) {
            case "log":
                return "file-text-o"
            case "image":
                return "file-image-o"
            default:
                return "file"
        }
    }

    _getArtifactIconColor(type) {
        switch (type) {
            case "log":
                return "text-success"
            case "image":
                return "text-primary"
            default:
                return "text-muted"
        }
    }

    _formatBytes(bytes, decimals = 2) {
        if (bytes === 0) return '0 Bytes';

        const k = 1024;
        const dm = decimals < 0 ? 0 : decimals;
        const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

        const i = Math.floor(Math.log(bytes) / Math.log(k));

        return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
    }
}