// source: GetTestDetailsRequest.proto
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

goog.exportSymbol('proto.server.GetTestDetailsRequest', null, global);
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
proto.server.GetTestDetailsRequest = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.server.GetTestDetailsRequest, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.server.GetTestDetailsRequest.displayName = 'proto.server.GetTestDetailsRequest';
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
proto.server.GetTestDetailsRequest.prototype.toObject = function(opt_includeInstance) {
  return proto.server.GetTestDetailsRequest.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.server.GetTestDetailsRequest} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.server.GetTestDetailsRequest.toObject = function(includeInstance, msg) {
  var f, obj = {
    workkey: jspb.Message.getFieldWithDefault(msg, 1, ""),
    devicekey: jspb.Message.getFieldWithDefault(msg, 2, ""),
    testkey: jspb.Message.getFieldWithDefault(msg, 3, "")
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
 * @return {!proto.server.GetTestDetailsRequest}
 */
proto.server.GetTestDetailsRequest.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.server.GetTestDetailsRequest;
  return proto.server.GetTestDetailsRequest.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.server.GetTestDetailsRequest} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.server.GetTestDetailsRequest}
 */
proto.server.GetTestDetailsRequest.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {string} */ (reader.readString());
      msg.setWorkkey(value);
      break;
    case 2:
      var value = /** @type {string} */ (reader.readString());
      msg.setDevicekey(value);
      break;
    case 3:
      var value = /** @type {string} */ (reader.readString());
      msg.setTestkey(value);
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
proto.server.GetTestDetailsRequest.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.server.GetTestDetailsRequest.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.server.GetTestDetailsRequest} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.server.GetTestDetailsRequest.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getWorkkey();
  if (f.length > 0) {
    writer.writeString(
      1,
      f
    );
  }
  f = message.getDevicekey();
  if (f.length > 0) {
    writer.writeString(
      2,
      f
    );
  }
  f = message.getTestkey();
  if (f.length > 0) {
    writer.writeString(
      3,
      f
    );
  }
};


/**
 * optional string workKey = 1;
 * @return {string}
 */
proto.server.GetTestDetailsRequest.prototype.getWorkkey = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 1, ""));
};


/**
 * @param {string} value
 * @return {!proto.server.GetTestDetailsRequest} returns this
 */
proto.server.GetTestDetailsRequest.prototype.setWorkkey = function(value) {
  return jspb.Message.setProto3StringField(this, 1, value);
};


/**
 * optional string deviceKey = 2;
 * @return {string}
 */
proto.server.GetTestDetailsRequest.prototype.getDevicekey = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 2, ""));
};


/**
 * @param {string} value
 * @return {!proto.server.GetTestDetailsRequest} returns this
 */
proto.server.GetTestDetailsRequest.prototype.setDevicekey = function(value) {
  return jspb.Message.setProto3StringField(this, 2, value);
};


/**
 * optional string testKey = 3;
 * @return {string}
 */
proto.server.GetTestDetailsRequest.prototype.getTestkey = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 3, ""));
};


/**
 * @param {string} value
 * @return {!proto.server.GetTestDetailsRequest} returns this
 */
proto.server.GetTestDetailsRequest.prototype.setTestkey = function(value) {
  return jspb.Message.setProto3StringField(this, 3, value);
};


goog.object.extend(exports, proto.server);