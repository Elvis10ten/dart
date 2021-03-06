// source: NetworkStats.proto
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

goog.exportSymbol('proto.stats.NetworkStats', null, global);
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
proto.stats.NetworkStats = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.stats.NetworkStats, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.stats.NetworkStats.displayName = 'proto.stats.NetworkStats';
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
proto.stats.NetworkStats.prototype.toObject = function(opt_includeInstance) {
  return proto.stats.NetworkStats.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.stats.NetworkStats} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.stats.NetworkStats.toObject = function(includeInstance, msg) {
  var f, obj = {
    rxpackets: jspb.Message.getFieldWithDefault(msg, 1, 0),
    txpackets: jspb.Message.getFieldWithDefault(msg, 2, 0),
    txbytes: jspb.Message.getFieldWithDefault(msg, 3, 0),
    rxbytes: jspb.Message.getFieldWithDefault(msg, 4, 0),
    relativetime: jspb.Message.getFieldWithDefault(msg, 5, 0)
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
 * @return {!proto.stats.NetworkStats}
 */
proto.stats.NetworkStats.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.stats.NetworkStats;
  return proto.stats.NetworkStats.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.stats.NetworkStats} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.stats.NetworkStats}
 */
proto.stats.NetworkStats.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {number} */ (reader.readInt64());
      msg.setRxpackets(value);
      break;
    case 2:
      var value = /** @type {number} */ (reader.readInt64());
      msg.setTxpackets(value);
      break;
    case 3:
      var value = /** @type {number} */ (reader.readInt64());
      msg.setTxbytes(value);
      break;
    case 4:
      var value = /** @type {number} */ (reader.readInt64());
      msg.setRxbytes(value);
      break;
    case 5:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setRelativetime(value);
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
proto.stats.NetworkStats.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.stats.NetworkStats.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.stats.NetworkStats} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.stats.NetworkStats.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getRxpackets();
  if (f !== 0) {
    writer.writeInt64(
      1,
      f
    );
  }
  f = message.getTxpackets();
  if (f !== 0) {
    writer.writeInt64(
      2,
      f
    );
  }
  f = message.getTxbytes();
  if (f !== 0) {
    writer.writeInt64(
      3,
      f
    );
  }
  f = message.getRxbytes();
  if (f !== 0) {
    writer.writeInt64(
      4,
      f
    );
  }
  f = message.getRelativetime();
  if (f !== 0) {
    writer.writeInt32(
      5,
      f
    );
  }
};


/**
 * optional int64 rxPackets = 1;
 * @return {number}
 */
proto.stats.NetworkStats.prototype.getRxpackets = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 1, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.NetworkStats} returns this
 */
proto.stats.NetworkStats.prototype.setRxpackets = function(value) {
  return jspb.Message.setProto3IntField(this, 1, value);
};


/**
 * optional int64 txPackets = 2;
 * @return {number}
 */
proto.stats.NetworkStats.prototype.getTxpackets = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 2, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.NetworkStats} returns this
 */
proto.stats.NetworkStats.prototype.setTxpackets = function(value) {
  return jspb.Message.setProto3IntField(this, 2, value);
};


/**
 * optional int64 txBytes = 3;
 * @return {number}
 */
proto.stats.NetworkStats.prototype.getTxbytes = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 3, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.NetworkStats} returns this
 */
proto.stats.NetworkStats.prototype.setTxbytes = function(value) {
  return jspb.Message.setProto3IntField(this, 3, value);
};


/**
 * optional int64 rxBytes = 4;
 * @return {number}
 */
proto.stats.NetworkStats.prototype.getRxbytes = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 4, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.NetworkStats} returns this
 */
proto.stats.NetworkStats.prototype.setRxbytes = function(value) {
  return jspb.Message.setProto3IntField(this, 4, value);
};


/**
 * optional int32 relativeTime = 5;
 * @return {number}
 */
proto.stats.NetworkStats.prototype.getRelativetime = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 5, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.NetworkStats} returns this
 */
proto.stats.NetworkStats.prototype.setRelativetime = function(value) {
  return jspb.Message.setProto3IntField(this, 5, value);
};


goog.object.extend(exports, proto.stats);
