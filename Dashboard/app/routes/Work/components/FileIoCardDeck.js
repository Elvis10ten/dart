import React, {Component} from 'react';

import colors from './../../../colors';
import PropTypes from "prop-types";
import { Container } from "../../../components";
import SimpleBarChartCard from "./SimpleBarChartCard";
import StackedAreaChartCard, {AreaVariable} from "./StackedAreaChartCard";
import SimpleLineChartCard, {SimpleLineVariable} from "./SimpleLineChartCard";
import {bytesToKilobytes} from "./StatsUtils";

const { FileIoStats } = require("./../../../proto/FileIoStats_pb")

export default class FileIoCardDeck extends Component {

    static propTypes = {
        fileIoStatsList: PropTypes.arrayOf(PropTypes.instanceOf(FileIoStats))
    }

    _formatCharsFileStat(fileIoStats, lastFileIoStats) {
        return ({
            charsWrite: bytesToKilobytes(fileIoStats.getCharswritebytes() - lastFileIoStats.getCharswritebytes()),
            charsRead: bytesToKilobytes(fileIoStats.getCharsreadbytes() - lastFileIoStats.getCharsreadbytes()),
            time: (fileIoStats.getRelativetime() / 1000)
        })
    }

    _formatBytesFileStat(fileIoStats, lastFileIoStats) {
        return ({
            read: bytesToKilobytes(fileIoStats.getReadbytes() - lastFileIoStats.getReadbytes()),
            write: bytesToKilobytes(fileIoStats.getWritebytes() - lastFileIoStats.getWritebytes()),
            time: (fileIoStats.getRelativetime() / 1000)
        })
    }

    _formatFileSysCallsStat(fileIoStats, lastFileIoStats) {
        return ({
            sysReads: fileIoStats.getNumsysreadcalls() - lastFileIoStats.getNumsysreadcalls(),
            sysWrites: fileIoStats.getNumsyswritecalls() - lastFileIoStats.getNumsyswritecalls(),
            time: (fileIoStats.getRelativetime() / 1000)
        })
    }

    render() {
        const charsFileStatsList = [];
        const bytesFileStatsList = [];
        const sysCallStatsList = [];

        let lastFileIoStats = this.props.fileIoStatsList[0];
        this.props.fileIoStatsList.map((fileIoStats) => {
            charsFileStatsList.push(this._formatCharsFileStat(fileIoStats, lastFileIoStats));
            bytesFileStatsList.push(this._formatBytesFileStat(fileIoStats, lastFileIoStats));
            sysCallStatsList.push(this._formatFileSysCallsStat(fileIoStats, lastFileIoStats));
            lastFileIoStats = fileIoStats;
        })

        return (
            <Container>
                <StackedAreaChartCard
                    items={ charsFileStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variablesUnit="kb"
                    variables={[
                        new AreaVariable("charsWrite", colors['primary'], colors['primary-03']),
                        new AreaVariable("charsRead", colors['purple'], colors['purple-03'])
                    ]}
                    title="Files Chars Read/Write"
                    subtitle="It includes things such as terminal I/O and is
                    unaffected by whether or not actual physical disk I/O
                    was required (the read/write might have been satisfied from
                    pagecache)"
                />

                <SimpleLineChartCard
                    items={ sysCallStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variables={[
                        new SimpleLineVariable("sysWrites", colors['primary'], colors['primary-03']),
                        new SimpleLineVariable("sysReads", colors['purple'], colors['purple-03'])
                    ]}
                    title="Sys Read/Write"
                    subtitle="Attempt to count the number of write/read I/O operations"
                    />

                <StackedAreaChartCard
                    items={ bytesFileStatsList }
                    individualsKey="time"
                    individualsUnit="s"
                    variablesUnit="kb"
                    variables={[
                        new AreaVariable("write", colors['primary'], colors['primary-03']),
                        new AreaVariable("read", colors['purple'], colors['purple-03'])
                    ]}
                    title="Files Bytes Read/Write"
                    subtitle="Attempt to count the number of bytes which this process really did cause to be fetched/written from the storage layer."
                />
            </Container>
        )
    }
}