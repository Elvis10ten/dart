import React, {Component} from 'react';
import PropTypes from 'prop-types';
import { 
    Line, 
    CartesianGrid, 
    XAxis, 
    YAxis, 
    Tooltip, 
    ResponsiveContainer,
    Legend, 
    LineChart
} from './../../../components/recharts';
import {Card, CardBody} from "../../../components";

export default class SimpleLineChartCard extends Component {

    static propTypes = {
        title: PropTypes.string,
        subtitle: PropTypes.string,
        items: PropTypes.array,
        individualsKey: PropTypes.string,
        individualsUnit: PropTypes.string,
        variablesUnit: PropTypes.string,
        variables: PropTypes.instanceOf(SimpleLineVariable)
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
                    { this._getSimpleLineChart() }
                </CardBody>
            </Card>
        )
    }

    _getSimpleLineChart() {
        return (
            <ResponsiveContainer width='100%' aspect={6.0/3.0}>
                <LineChart
                    data={ this.props.items }
                    margin={{top: 5, right: 30, left: 20, bottom: 5}}
                >
                    <XAxis
                        dataKey={ this.props.individualsKey }
                        unit={ this.props.individualsUnit }
                    />
                    <YAxis/>
                    <CartesianGrid strokeDasharray="3 3"/>
                    <Tooltip/>
                    <Legend />
                    {
                        this.props.variables.map((variable) =>
                            this._getLine(variable)
                        )
                    }
                </LineChart>
            </ResponsiveContainer>
        )
    }

    _getLine(variable) {
        return (
            <Line
                dataKey={ variable.key }
                stroke={ variable.strokeColor }
                fill={ variable.fillColor }
                unit={ this.props.variablesUnit }
            />
        )
    }
}

export function SimpleLineVariable(key, strokeColor, fillColor) {
    this.key = key;
    this.strokeColor = strokeColor;
    this.fillColor = fillColor;
}