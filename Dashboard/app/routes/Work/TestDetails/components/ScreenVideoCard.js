import React, {Component} from 'react';
import PropTypes from "prop-types";
import {
    Player,
    LoadingSpinner,
    ControlBar,
    BigPlayButton,
    PlayToggle,
    ReplayControl,
    ForwardControl,
    FullscreenToggle,
    ProgressControl,
    CurrentTimeDisplay,
    DurationDisplay,
    TimeDivider
} from 'video-react';
import {Card, CardBody, Col} from "../../../../components";

const { DeviceProperty, RemoteFile } = require("./../../../../proto/TestDetails_pb")

export default class ScreenVideoCard extends Component {

    static propTypes = {
        videoFile: PropTypes.instanceOf(RemoteFile),
        deviceProps: PropTypes.arrayOf(PropTypes.instanceOf(DeviceProperty)),
        onPositionChanged: PropTypes.func
    }

    constructor(props) {
        super(props);
        this.lastVideoPosition = null;
    }

    componentDidMount() {
        this.videoPlayer.subscribeToStateChange((videoState) => {
            if(this.lastVideoPosition !== videoState.currentTime) {
                this.lastVideoPosition = videoState.currentTime
                this.props.onPositionChanged(videoState.currentTime)
            }
        })
    }

    componentWillUnmount() {
        this.videoPlayer.subscribeToStateChange(null)
    }

    render() {
        const propsView = this.props.deviceProps.map((prop) =>
            this._getPropView(prop)
        );

        return (
            <Col
                lg={4}
                className="position-sticky"
            >
                <Card>
                    <Player
                        src={this.props.videoFile.getUrl()}
                        ref={ (videoPlayer) => {
                            this.videoPlayer = videoPlayer;
                        }}>

                        <LoadingSpinner/>
                        <BigPlayButton position="center"/>

                        <ControlBar
                            autoHide={false}
                            disableDefaultControls={true}
                            autoPlay={false}
                        >

                            <ReplayControl seconds={5} order={2.1}/>
                            <PlayToggle order={2.2}/>
                            <ForwardControl seconds={5} order={2.3}/>
                            <CurrentTimeDisplay order={2.4}/>
                            <TimeDivider order={2.5}/>
                            <DurationDisplay order={2.6}/>
                            <ProgressControl order={2.7}/>
                            <FullscreenToggle order={2.8}/>

                        </ControlBar>
                    </Player>

                    <CardBody>
                        { propsView }
                    </CardBody>
                </Card>
            </Col>
        )
    }

    seek(newPosition) {
        this.videoPlayer.seek(newPosition)
    }

    _getPropView(prop) {
        return (
            <span><b>{prop.getName()}</b>: {prop.getValue()}<br/></span>
        )
    }
}