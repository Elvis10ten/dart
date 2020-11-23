// source: FindWorkResponse.proto
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

var Work_pb = require('./Work_pb.js');
goog.object.extend(proto, Work_pb);
goog.exportSymbol('proto.server.FindWorkResponse', null, global);
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
proto.server.FindWorkResponse = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.server.FindWorkResponse, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.server.FindWorkResponse.displayName = 'proto.server.FindWorkResponse';
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
proto.server.FindWorkResponse.prototype.toObject = function(opt_includeInstance) {
  return proto.server.FindWorkResponse.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.server.FindWorkResponse} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.server.FindWorkResponse.toObject = function(includeInstance, msg) {
  var f, obj = {
    work: (f = msg.getWork()) && Work_pb.Work.toObject(includeInstance, f)
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
 * @return {!proto.server.FindWorkResponse}
 */
proto.server.FindWorkResponse.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.server.FindWorkResponse;
  return proto.server.FindWorkResponse.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.server.FindWorkResponse} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.server.FindWorkResponse}
 */
proto.server.FindWorkResponse.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = new Work_pb.Work;
      reader.readMessage(value,Work_pb.Work.deserializeBinaryFromReader);
      msg.setWork(value);
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
proto.server.FindWorkResponse.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.server.FindWorkResponse.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.server.FindWorkResponse} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.server.FindWorkResponse.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getWork();
  if (f != null) {
    writer.writeMessage(
      1,
      f,
      Work_pb.Work.serializeBinaryToWriter
    );
  }
};


/**
 * optional work.Work work = 1;
 * @return {?proto.work.Work}
 */
proto.server.FindWorkResponse.prototype.getWork = function() {
  return /** @type{?proto.work.Work} */ (
    jspb.Message.getWrapperField(this, Work_pb.Work, 1));
};


/**
 * @param {?proto.work.Work|undefined} value
 * @return {!proto.server.FindWorkResponse} returns this
*/
proto.server.FindWorkResponse.prototype.setWork = function(value) {
  return jspb.Message.setWrapperField(this, 1, value);
};


/**
 * Clears the message field making it undefined.
 * @return {!proto.server.FindWorkResponse} returns this
 */
proto.server.FindWorkResponse.prototype.clearWork = function() {
  return this.setWork(undefined);
};


/**
 * Returns whether this field is set.
 * @return {boolean}
 */
proto.server.FindWorkResponse.prototype.hasWork = function() {
  return jspb.Message.getField(this, 1) != null;
};


goog.object.extend(exports, proto.server);
