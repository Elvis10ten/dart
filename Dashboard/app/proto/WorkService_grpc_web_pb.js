/**
 * @fileoverview gRPC-Web generated client stub for server
 * @enhanceable
 * @public
 */

// GENERATED CODE -- DO NOT EDIT!



const grpc = {};
grpc.web = require('grpc-web');


var FindWorkRequest_pb = require('./FindWorkRequest_pb.js')

var FindWorkResponse_pb = require('./FindWorkResponse_pb.js')

var DelineateWorkRequest_pb = require('./DelineateWorkRequest_pb.js')

var DelineateWorkResponse_pb = require('./DelineateWorkResponse_pb.js')

var FileTransfer_pb = require('./FileTransfer_pb.js')

var SendFileWrapper_pb = require('./SendFileWrapper_pb.js')

var UploadResultResponse_pb = require('./UploadResultResponse_pb.js')

var GetWorkUpdatesRequest_pb = require('./GetWorkUpdatesRequest_pb.js')

var GetWorkUpdatesResponse_pb = require('./GetWorkUpdatesResponse_pb.js')

var GetWorkDevicesRequest_pb = require('./GetWorkDevicesRequest_pb.js')

var GetWorkDevicesResponse_pb = require('./GetWorkDevicesResponse_pb.js')

var GetWorkRequest_pb = require('./GetWorkRequest_pb.js')

var GetWorkResponse_pb = require('./GetWorkResponse_pb.js')

var GetTestDetailsRequest_pb = require('./GetTestDetailsRequest_pb.js')

var GetTestDetailsResponse_pb = require('./GetTestDetailsResponse_pb.js')

var GetTestPerformanceRequest_pb = require('./GetTestPerformanceRequest_pb.js')

var GetTestPerformanceResponse_pb = require('./GetTestPerformanceResponse_pb.js')

var GetTestLogsRequest_pb = require('./GetTestLogsRequest_pb.js')

var GetTestLogsResponse_pb = require('./GetTestLogsResponse_pb.js')
const proto = {};
proto.server = require('./WorkService_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.server.WorkServiceClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.server.WorkServicePromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.GetWorkDevicesRequest,
 *   !proto.server.GetWorkDevicesResponse>}
 */
const methodDescriptor_WorkService_GetWorkDevices = new grpc.web.MethodDescriptor(
  '/server.WorkService/GetWorkDevices',
  grpc.web.MethodType.UNARY,
  GetWorkDevicesRequest_pb.GetWorkDevicesRequest,
  GetWorkDevicesResponse_pb.GetWorkDevicesResponse,
  /**
   * @param {!proto.server.GetWorkDevicesRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetWorkDevicesResponse_pb.GetWorkDevicesResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.GetWorkDevicesRequest,
 *   !proto.server.GetWorkDevicesResponse>}
 */
const methodInfo_WorkService_GetWorkDevices = new grpc.web.AbstractClientBase.MethodInfo(
  GetWorkDevicesResponse_pb.GetWorkDevicesResponse,
  /**
   * @param {!proto.server.GetWorkDevicesRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetWorkDevicesResponse_pb.GetWorkDevicesResponse.deserializeBinary
);


/**
 * @param {!proto.server.GetWorkDevicesRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.GetWorkDevicesResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.GetWorkDevicesResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.getWorkDevices =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/GetWorkDevices',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetWorkDevices,
      callback);
};


/**
 * @param {!proto.server.GetWorkDevicesRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.GetWorkDevicesResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.getWorkDevices =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/GetWorkDevices',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetWorkDevices);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.GetWorkUpdatesRequest,
 *   !proto.server.GetWorkUpdatesResponse>}
 */
const methodDescriptor_WorkService_GetWorkUpdates = new grpc.web.MethodDescriptor(
  '/server.WorkService/GetWorkUpdates',
  grpc.web.MethodType.UNARY,
  GetWorkUpdatesRequest_pb.GetWorkUpdatesRequest,
  GetWorkUpdatesResponse_pb.GetWorkUpdatesResponse,
  /**
   * @param {!proto.server.GetWorkUpdatesRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetWorkUpdatesResponse_pb.GetWorkUpdatesResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.GetWorkUpdatesRequest,
 *   !proto.server.GetWorkUpdatesResponse>}
 */
const methodInfo_WorkService_GetWorkUpdates = new grpc.web.AbstractClientBase.MethodInfo(
  GetWorkUpdatesResponse_pb.GetWorkUpdatesResponse,
  /**
   * @param {!proto.server.GetWorkUpdatesRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetWorkUpdatesResponse_pb.GetWorkUpdatesResponse.deserializeBinary
);


/**
 * @param {!proto.server.GetWorkUpdatesRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.GetWorkUpdatesResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.GetWorkUpdatesResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.getWorkUpdates =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/GetWorkUpdates',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetWorkUpdates,
      callback);
};


/**
 * @param {!proto.server.GetWorkUpdatesRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.GetWorkUpdatesResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.getWorkUpdates =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/GetWorkUpdates',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetWorkUpdates);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.GetWorkRequest,
 *   !proto.server.GetWorkResponse>}
 */
const methodDescriptor_WorkService_GetWork = new grpc.web.MethodDescriptor(
  '/server.WorkService/GetWork',
  grpc.web.MethodType.UNARY,
  GetWorkRequest_pb.GetWorkRequest,
  GetWorkResponse_pb.GetWorkResponse,
  /**
   * @param {!proto.server.GetWorkRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetWorkResponse_pb.GetWorkResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.GetWorkRequest,
 *   !proto.server.GetWorkResponse>}
 */
const methodInfo_WorkService_GetWork = new grpc.web.AbstractClientBase.MethodInfo(
  GetWorkResponse_pb.GetWorkResponse,
  /**
   * @param {!proto.server.GetWorkRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetWorkResponse_pb.GetWorkResponse.deserializeBinary
);


/**
 * @param {!proto.server.GetWorkRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.GetWorkResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.GetWorkResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.getWork =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/GetWork',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetWork,
      callback);
};


/**
 * @param {!proto.server.GetWorkRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.GetWorkResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.getWork =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/GetWork',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetWork);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.GetTestDetailsRequest,
 *   !proto.server.GetTestDetailsResponse>}
 */
const methodDescriptor_WorkService_GetTestDetails = new grpc.web.MethodDescriptor(
  '/server.WorkService/GetTestDetails',
  grpc.web.MethodType.UNARY,
  GetTestDetailsRequest_pb.GetTestDetailsRequest,
  GetTestDetailsResponse_pb.GetTestDetailsResponse,
  /**
   * @param {!proto.server.GetTestDetailsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetTestDetailsResponse_pb.GetTestDetailsResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.GetTestDetailsRequest,
 *   !proto.server.GetTestDetailsResponse>}
 */
const methodInfo_WorkService_GetTestDetails = new grpc.web.AbstractClientBase.MethodInfo(
  GetTestDetailsResponse_pb.GetTestDetailsResponse,
  /**
   * @param {!proto.server.GetTestDetailsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetTestDetailsResponse_pb.GetTestDetailsResponse.deserializeBinary
);


/**
 * @param {!proto.server.GetTestDetailsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.GetTestDetailsResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.GetTestDetailsResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.getTestDetails =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/GetTestDetails',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetTestDetails,
      callback);
};


/**
 * @param {!proto.server.GetTestDetailsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.GetTestDetailsResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.getTestDetails =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/GetTestDetails',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetTestDetails);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.GetTestPerformanceRequest,
 *   !proto.server.GetTestPerformanceResponse>}
 */
const methodDescriptor_WorkService_GetTestPerformance = new grpc.web.MethodDescriptor(
  '/server.WorkService/GetTestPerformance',
  grpc.web.MethodType.UNARY,
  GetTestPerformanceRequest_pb.GetTestPerformanceRequest,
  GetTestPerformanceResponse_pb.GetTestPerformanceResponse,
  /**
   * @param {!proto.server.GetTestPerformanceRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetTestPerformanceResponse_pb.GetTestPerformanceResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.GetTestPerformanceRequest,
 *   !proto.server.GetTestPerformanceResponse>}
 */
const methodInfo_WorkService_GetTestPerformance = new grpc.web.AbstractClientBase.MethodInfo(
  GetTestPerformanceResponse_pb.GetTestPerformanceResponse,
  /**
   * @param {!proto.server.GetTestPerformanceRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetTestPerformanceResponse_pb.GetTestPerformanceResponse.deserializeBinary
);


/**
 * @param {!proto.server.GetTestPerformanceRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.GetTestPerformanceResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.GetTestPerformanceResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.getTestPerformance =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/GetTestPerformance',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetTestPerformance,
      callback);
};


/**
 * @param {!proto.server.GetTestPerformanceRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.GetTestPerformanceResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.getTestPerformance =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/GetTestPerformance',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetTestPerformance);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.GetTestLogsRequest,
 *   !proto.server.GetTestLogsResponse>}
 */
const methodDescriptor_WorkService_GetTestLogs = new grpc.web.MethodDescriptor(
  '/server.WorkService/GetTestLogs',
  grpc.web.MethodType.UNARY,
  GetTestLogsRequest_pb.GetTestLogsRequest,
  GetTestLogsResponse_pb.GetTestLogsResponse,
  /**
   * @param {!proto.server.GetTestLogsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetTestLogsResponse_pb.GetTestLogsResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.GetTestLogsRequest,
 *   !proto.server.GetTestLogsResponse>}
 */
const methodInfo_WorkService_GetTestLogs = new grpc.web.AbstractClientBase.MethodInfo(
  GetTestLogsResponse_pb.GetTestLogsResponse,
  /**
   * @param {!proto.server.GetTestLogsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  GetTestLogsResponse_pb.GetTestLogsResponse.deserializeBinary
);


/**
 * @param {!proto.server.GetTestLogsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.GetTestLogsResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.GetTestLogsResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.getTestLogs =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/GetTestLogs',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetTestLogs,
      callback);
};


/**
 * @param {!proto.server.GetTestLogsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.GetTestLogsResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.getTestLogs =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/GetTestLogs',
      request,
      metadata || {},
      methodDescriptor_WorkService_GetTestLogs);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.FindWorkRequest,
 *   !proto.server.FindWorkResponse>}
 */
const methodDescriptor_WorkService_Find = new grpc.web.MethodDescriptor(
  '/server.WorkService/Find',
  grpc.web.MethodType.UNARY,
  FindWorkRequest_pb.FindWorkRequest,
  FindWorkResponse_pb.FindWorkResponse,
  /**
   * @param {!proto.server.FindWorkRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  FindWorkResponse_pb.FindWorkResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.FindWorkRequest,
 *   !proto.server.FindWorkResponse>}
 */
const methodInfo_WorkService_Find = new grpc.web.AbstractClientBase.MethodInfo(
  FindWorkResponse_pb.FindWorkResponse,
  /**
   * @param {!proto.server.FindWorkRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  FindWorkResponse_pb.FindWorkResponse.deserializeBinary
);


/**
 * @param {!proto.server.FindWorkRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.FindWorkResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.FindWorkResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.find =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/Find',
      request,
      metadata || {},
      methodDescriptor_WorkService_Find,
      callback);
};


/**
 * @param {!proto.server.FindWorkRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.FindWorkResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.find =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/Find',
      request,
      metadata || {},
      methodDescriptor_WorkService_Find);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.server.DelineateWorkRequest,
 *   !proto.server.DelineateWorkResponse>}
 */
const methodDescriptor_WorkService_Delineate = new grpc.web.MethodDescriptor(
  '/server.WorkService/Delineate',
  grpc.web.MethodType.UNARY,
  DelineateWorkRequest_pb.DelineateWorkRequest,
  DelineateWorkResponse_pb.DelineateWorkResponse,
  /**
   * @param {!proto.server.DelineateWorkRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  DelineateWorkResponse_pb.DelineateWorkResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.server.DelineateWorkRequest,
 *   !proto.server.DelineateWorkResponse>}
 */
const methodInfo_WorkService_Delineate = new grpc.web.AbstractClientBase.MethodInfo(
  DelineateWorkResponse_pb.DelineateWorkResponse,
  /**
   * @param {!proto.server.DelineateWorkRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  DelineateWorkResponse_pb.DelineateWorkResponse.deserializeBinary
);


/**
 * @param {!proto.server.DelineateWorkRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.server.DelineateWorkResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.server.DelineateWorkResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.server.WorkServiceClient.prototype.delineate =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/server.WorkService/Delineate',
      request,
      metadata || {},
      methodDescriptor_WorkService_Delineate,
      callback);
};


/**
 * @param {!proto.server.DelineateWorkRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.server.DelineateWorkResponse>}
 *     A native promise that resolves to the response
 */
proto.server.WorkServicePromiseClient.prototype.delineate =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/server.WorkService/Delineate',
      request,
      metadata || {},
      methodDescriptor_WorkService_Delineate);
};


module.exports = proto.server;

