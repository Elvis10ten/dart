// source: GcStats.proto
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

goog.exportSymbol('proto.stats.GcStats', null, global);
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
proto.stats.GcStats = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.stats.GcStats, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.stats.GcStats.displayName = 'proto.stats.GcStats';
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
proto.stats.GcStats.prototype.toObject = function(opt_includeInstance) {
  return proto.stats.GcStats.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.stats.GcStats} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.stats.GcStats.toObject = function(includeInstance, msg) {
  var f, obj = {
    runcount: jspb.Message.getFieldWithDefault(msg, 1, 0),
    runtotalduration: jspb.Message.getFieldWithDefault(msg, 2, 0),
    totalbytesallocated: jspb.Message.getFieldWithDefault(msg, 3, 0),
    totalbytesfreed: jspb.Message.getFieldWithDefault(msg, 4, 0),
    blockingruncount: jspb.Message.getFieldWithDefault(msg, 5, 0),
    blockingruntotalduration: jspb.Message.getFieldWithDefault(msg, 6, 0),
    relativetime: jspb.Message.getFieldWithDefault(msg, 9, 0)
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
 * @return {!proto.stats.GcStats}
 */
proto.stats.GcStats.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.stats.GcStats;
  return proto.stats.GcStats.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.stats.GcStats} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.stats.GcStats}
 */
proto.stats.GcStats.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setRuncount(value);
      break;
    case 2:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setRuntotalduration(value);
      break;
    case 3:
      var value = /** @type {number} */ (reader.readInt64());
      msg.setTotalbytesallocated(value);
      break;
    case 4:
      var value = /** @type {number} */ (reader.readInt64());
      msg.setTotalbytesfreed(value);
      break;
    case 5:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setBlockingruncount(value);
      break;
    case 6:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setBlockingruntotalduration(value);
      break;
    case 9:
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
proto.stats.GcStats.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.stats.GcStats.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.stats.GcStats} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.stats.GcStats.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getRuncount();
  if (f !== 0) {
    writer.writeInt32(
      1,
      f
    );
  }
  f = message.getRuntotalduration();
  if (f !== 0) {
    writer.writeInt32(
      2,
      f
    );
  }
  f = message.getTotalbytesallocated();
  if (f !== 0) {
    writer.writeInt64(
      3,
      f
    );
  }
  f = message.getTotalbytesfreed();
  if (f !== 0) {
    writer.writeInt64(
      4,
      f
    );
  }
  f = message.getBlockingruncount();
  if (f !== 0) {
    writer.writeInt32(
      5,
      f
    );
  }
  f = message.getBlockingruntotalduration();
  if (f !== 0) {
    writer.writeInt32(
      6,
      f
    );
  }
  f = message.getRelativetime();
  if (f !== 0) {
    writer.writeInt32(
      9,
      f
    );
  }
};


/**
 * optional int32 runCount = 1;
 * @return {number}
 */
proto.stats.GcStats.prototype.getRuncount = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 1, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setRuncount = function(value) {
  return jspb.Message.setProto3IntField(this, 1, value);
};


/**
 * optional int32 runTotalDuration = 2;
 * @return {number}
 */
proto.stats.GcStats.prototype.getRuntotalduration = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 2, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setRuntotalduration = function(value) {
  return jspb.Message.setProto3IntField(this, 2, value);
};


/**
 * optional int64 totalBytesAllocated = 3;
 * @return {number}
 */
proto.stats.GcStats.prototype.getTotalbytesallocated = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 3, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setTotalbytesallocated = function(value) {
  return jspb.Message.setProto3IntField(this, 3, value);
};


/**
 * optional int64 totalBytesFreed = 4;
 * @return {number}
 */
proto.stats.GcStats.prototype.getTotalbytesfreed = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 4, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setTotalbytesfreed = function(value) {
  return jspb.Message.setProto3IntField(this, 4, value);
};


/**
 * optional int32 blockingRunCount = 5;
 * @return {number}
 */
proto.stats.GcStats.prototype.getBlockingruncount = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 5, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setBlockingruncount = function(value) {
  return jspb.Message.setProto3IntField(this, 5, value);
};


/**
 * optional int32 blockingRunTotalDuration = 6;
 * @return {number}
 */
proto.stats.GcStats.prototype.getBlockingruntotalduration = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 6, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setBlockingruntotalduration = function(value) {
  return jspb.Message.setProto3IntField(this, 6, value);
};


/**
 * optional int32 relativeTime = 9;
 * @return {number}
 */
proto.stats.GcStats.prototype.getRelativetime = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 9, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.GcStats} returns this
 */
proto.stats.GcStats.prototype.setRelativetime = function(value) {
  return jspb.Message.setProto3IntField(this, 9, value);
};


goog.object.extend(exports, proto.stats);
