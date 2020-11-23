import React, {Component} from 'react';
import { 
    BarChart, 
    CartesianGrid, 
    XAxis, 
    YAxis, 
    Tooltip, 
    ResponsiveContainer,
    Legend, 
    Bar
} from './../../../components/recharts';

import colors from './../../../colors';
import PropTypes from "prop-types";
import {Card, CardBody} from "../../../components";

export default class SimpleBarChartCard extends Component {

    static propTypes = {
        title: PropTypes.string,
        subtitle: PropTypes.string,
        items: PropTypes.array,
        individualsKey: PropTypes.string,
        variables: PropTypes.instanceOf(SimpleBarVariable)
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
                    { this._getSimpleBarChart() }
                </CardBody>
            </Card>
        )
    }

    _getSimpleBarChart() {
        return (
            <ResponsiveContainer width='100%' aspect={6.0/3.0}>
                <BarChart
                    data={ this.props.items }
                    margin={{top: 5, right: 30, left: 20, bottom: 5}}
                >
                    <CartesianGrid strokeDasharray="3 3"/>
                    <XAxis dataKey={ this.props.individualsKey } />
                    <YAxis />
                    <Tooltip
                        contentStyle={{
                            background: colors['900'],
                            border: `1px solid ${colors['900']}`,
                            color: colors['white']
                        }}
                    />

                    <Legend wrapperStyle={{ color: colors['900'] }}/>

                    {
                        this.props.variables.map((variable) =>
                            this._getBar(variable)
                        )
                    }
                </BarChart>
            </ResponsiveContainer>
        )
    }

    _getBar(variable) {
        return (
            <Bar
                dataKey={ variable.key }
                fill={ variable.color }
                barSize={ 5 }
                stackId={ variable.stackId }
            />
        )
    }
}

export function SimpleBarVariable(key, color, stackId) {
    this.key = key;
    this.color = color;
    this.stackId = stackId;
}