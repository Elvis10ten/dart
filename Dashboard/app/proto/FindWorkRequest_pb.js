// source: FindWorkRequest.proto
/**
 * @fileoverview
 * @enhanceable
 * @suppress {messageConventions} JS Compiler reports an error if a variable or
 *     field starts with 'MSG_' and isn't a translatable message.
 * @public
 */
// GENERATED CODE -- DO NOT EDIT!

var jspb = require('google-protobuf');
var goog = jspb;
var global = Function('return this')();

var DeviceProperties_pb = require('./DeviceProperties_pb.js');
goog.object.extend(proto, DeviceProperties_pb);
goog.exportSymbol('proto.server.FindWorkRequest', null, global);
/**
 * Generated by JsPbCodeGenerator.
 * @param {Array=} opt_data Optional initial data array, typically from a
 * server response, or constructed directly in Javascript. The array is used
 * in place and becomes part of the constructed object. It is not cloned.
 * If no data is provided, the constructed object will be empty, but still
 * valid.
 * @extends {jspb.Message}
 * @constructor
 */
proto.server.FindWorkRequest = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.server.FindWorkRequest, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.server.FindWorkRequest.displayName = 'proto.server.FindWorkRequest';
}



if (jspb.Message.GENERATE_TO_OBJECT) {
/**
 * Creates an object representation of this proto.
 * Field names that are reserved in JavaScript and will be renamed to pb_name.
 * Optional fields that are not set will be set to undefined.
 * To access a reserved field use, foo.pb_<name>, eg, foo.pb_default.
 * For the list of reserved names please see:
 *     net/proto2/compiler/js/internal/generator.cc#kKeyword.
 * @param {boolean=} opt_includeInstance Deprecated. whether to include the
 *     JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @return {!Object}
 */
proto.server.FindWorkRequest.prototype.toObject = function(opt_includeInstance) {
  return proto.server.FindWorkRequest.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.server.FindWorkRequest} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.server.FindWorkRequest.toObject = function(includeInstance, msg) {
  var f, obj = {
    deviceproperties: (f = msg.getDeviceproperties()) && DeviceProperties_pb.DeviceProperties.toObject(includeInstance, f)
  };

  if (includeInstance) {
    obj.$jspbMessageInstance = msg;
  }
  return obj;
};
}


/**
 * Deserializes binary data (in protobuf wire format).
 * @param {jspb.ByteSource} bytes The bytes to deserialize.
 * @return {!proto.server.FindWorkRequest}
 */
proto.server.FindWorkRequest.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.server.FindWorkRequest;
  return proto.server.FindWorkRequest.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.server.FindWorkRequest} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.server.FindWorkRequest}
 */
proto.server.FindWorkRequest.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = new DeviceProperties_pb.DeviceProperties;
      reader.readMessage(value,DeviceProperties_pb.DeviceProperties.deserializeBinaryFromReader);
      msg.setDeviceproperties(value);
      break;
    default:
      reader.skipField();
      break;
    }
  }
  return msg;
};


/**
 * Serializes the message to binary data (in protobuf wire format).
 * @return {!Uint8Array}
 */
proto.server.FindWorkRequest.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.server.FindWorkRequest.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.server.FindWorkRequest} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.server.FindWorkRequest.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getDeviceproperties();
  if (f != null) {
    writer.writeMessage(
      1,
      f,
      DeviceProperties_pb.DeviceProperties.serializeBinaryToWriter
    );
  }
};


/**
 * optional device.DeviceProperties deviceProperties = 1;
 * @return {?proto.device.DeviceProperties}
 */
proto.server.FindWorkRequest.prototype.getDeviceproperties = function() {
  return /** @type{?proto.device.DeviceProperties} */ (
    jspb.Message.getWrapperField(this, DeviceProperties_pb.DeviceProperties, 1));
};


/**
 * @param {?proto.device.DeviceProperties|undefined} value
 * @return {!proto.server.FindWorkRequest} returns this
*/
proto.server.FindWorkRequest.prototype.setDeviceproperties = function(value) {
  return jspb.Message.setWrapperField(this, 1, value);
};


/**
 * Clears the message field making it undefined.
 * @return {!proto.server.FindWorkRequest} returns this
 */
proto.server.FindWorkRequest.prototype.clearDeviceproperties = function() {
  return this.setDeviceproperties(undefined);
};


/**
 * Returns whether this field is set.
 * @return {boolean}
 */
proto.server.FindWorkRequest.prototype.hasDeviceproperties = function() {
  return jspb.Message.getField(this, 1) != null;
};


goog.object.extend(exports, proto.server);
