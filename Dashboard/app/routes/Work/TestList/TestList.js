import React, {Component} from 'react';

import { 
    Pagination,
    PaginationItem,
    PaginationLink,
    Card,
    CardFooter,
    Table
} from './../../../components';

import { TrTableTasksList } from "./components/TrTableTasksList";

const { GetWorkDevicesRequest } = require("./../../../proto/GetWorkDevicesRequest_pb")
const { WorkServiceClient } = require("./../../../proto/WorkService_grpc_web_pb")

export default class TasksList extends Component {

    componentDidMount() {
        console.log("fuck5: real fucks!!!!");
        const client = new WorkServiceClient('http://localhost:9090');

        const request = new GetWorkDevicesRequest()
        request.workId = "4d653109-136c-4870-b0c9-503786d644f5"
        //request.deviceKey = "d3dacf1753e7728f"

        console.log("fuck5:" + JSON.stringify(request));
        client.getWorkDevices(request, {}, (err, response) => {
            console.log("Fuck5 : error: ",err)
            console.log("Fuck5 : response: ", JSON.stringify(response.getDevicesList()))
            /*this.setState({
                isLoading: false,
                performanceReport: response.getPerformancereport()
            })*/
        })
    }

    render() {
        return (
            <Card className="mb-3">
                { /* START Table */}
                <div className="table-responsive-xl">
                    <Table className="mb-0" hover>

                        <thead>
                        <tr>
                            <th className="align-middle bt-0"></th>
                            <th className="align-middle bt-0">Status</th>
                            <th className="align-middle bt-0">Test Name</th>
                            <th className="align-middle bt-0">Duration</th>
                            <th className="align-middle bt-0 text-right">
                                Actions
                            </th>
                        </tr>
                        </thead>

                        <tbody>
                        <TrTableTasksList
                            id="1"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="2"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="3"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="4"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="5"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="6"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="7"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="8"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="9"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        <TrTableTasksList
                            id="10"
                            workId="abacus"
                            deviceName="Samsung S9"
                        />
                        </tbody>
                    </Table>
                </div>
                { /* END Table */}

                <CardFooter className="d-flex justify-content-center pb-0">
                    <Pagination aria-label="Page navigation example">
                        <PaginationItem>
                            <PaginationLink previous href="#">
                                <i className="fa fa-fw fa-angle-left"></i>
                            </PaginationLink>
                        </PaginationItem>
                        <PaginationItem active>
                            <PaginationLink href="#">
                                1
                            </PaginationLink>
                        </PaginationItem>
                        <PaginationItem>
                            <PaginationLink href="#">
                                2
                            </PaginationLink>
                        </PaginationItem>
                        <PaginationItem>
                            <PaginationLink href="#">
                                3
                            </PaginationLink>
                        </PaginationItem>
                        <PaginationItem>
                            <PaginationLink next href="#">
                                <i className="fa fa-fw fa-angle-right"></i>
                            </PaginationLink>
                        </PaginationItem>
                    </Pagination>
                </CardFooter>
            </Card>
        )
    }
}
