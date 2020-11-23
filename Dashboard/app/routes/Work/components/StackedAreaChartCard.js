import React, {Component} from 'react';
import { 
    AreaChart, 
    CartesianGrid, 
    XAxis, 
    YAxis, 
    Tooltip, 
    ResponsiveContainer,
    Area
} from './../../../components/recharts';

import PropTypes from "prop-types";
import {Card, CardBody} from "../../../components";
import {Line, ReferenceLine } from "../../../components/recharts";
import colors from "../../../colors";

export default class StackedAreaChartCard extends Component {

    static propTypes = {
        title: PropTypes.string,
        subtitle: PropTypes.string,
        items: PropTypes.array,
        individualsKey: PropTypes.string,
        individualsUnit: PropTypes.string,
        variablesUnit: PropTypes.string,
        variables: PropTypes.arrayOf(PropTypes.instanceOf(AreaVariable)),
        onClick: PropTypes.func,
        referenceXPoint: PropTypes.number
    }

    render() {
        return (
            <Card className="mb-3">
                <CardBody>
                    <div className="d-flex">
                        <div>
                            <h6 className="card-title mb-1">
                                { this.props.title }
                            </h6>
                            <p>{ this.props.subtitle }</p>
                        </div>
                    </div>
                    { this._getStackedAreaChart() }
                </CardBody>
            </Card>
        )
    }

    _getStackedAreaChart() {
        let referenceLine = null;

        if (this.props.referenceXPoint !== undefined) {
            referenceLine = <ReferenceLine
                x={ this.props.referenceXPoint }
                stroke={ colors["primary"] } />;
        }

        return(
            <ResponsiveContainer width='100%' aspect={6.0/3.0}>
                <AreaChart
                    data={ this.props.items }
                    margin={{top: 10, right: 30, left: 0, bottom: 0}}
                    onClick={ this.props.onClick }>
                    <CartesianGrid strokeDasharray="3 3"/>
                    <XAxis
                        dataKey={ this.props.individualsKey }
                        unit={ this.props.individualsUnit }
                    />
                    <YAxis/>
                    <Tooltip />

                    { referenceLine }
                    {
                        this.props.variables.map((variable) =>
                            this._getArea(variable)
                        )
                    }
                </AreaChart>
            </ResponsiveContainer>
        )
    }

    _getArea(variable) {
        return (
            <Area
                dataKey={ variable.key }
                stackId="1"
                stroke={ variable.strokeColor }
                fill={ variable.fillColor }
                unit={ this.props.variablesUnit }
            />
        )
    }
}

export function AreaVariable(key, strokeColor, fillColor) {
    this.key = key;
    this.strokeColor = strokeColor;
    this.fillColor = fillColor;
}