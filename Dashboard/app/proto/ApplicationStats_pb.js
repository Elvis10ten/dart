// source: ApplicationStats.proto
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

goog.exportSymbol('proto.stats.ApplicationStats', null, global);
goog.exportSymbol('proto.stats.ApplicationStats.Stage', null, global);
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
proto.stats.ApplicationStats = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.stats.ApplicationStats, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.stats.ApplicationStats.displayName = 'proto.stats.ApplicationStats';
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
proto.stats.ApplicationStats.prototype.toObject = function(opt_includeInstance) {
  return proto.stats.ApplicationStats.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.stats.ApplicationStats} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.stats.ApplicationStats.toObject = function(includeInstance, msg) {
  var f, obj = {
    name: jspb.Message.getFieldWithDefault(msg, 1, ""),
    stage: jspb.Message.getFieldWithDefault(msg, 2, 0),
    relativetime: jspb.Message.getFieldWithDefault(msg, 3, 0)
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
 * @return {!proto.stats.ApplicationStats}
 */
proto.stats.ApplicationStats.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.stats.ApplicationStats;
  return proto.stats.ApplicationStats.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.stats.ApplicationStats} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.stats.ApplicationStats}
 */
proto.stats.ApplicationStats.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {string} */ (reader.readString());
      msg.setName(value);
      break;
    case 2:
      var value = /** @type {!proto.stats.ApplicationStats.Stage} */ (reader.readEnum());
      msg.setStage(value);
      break;
    case 3:
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
proto.stats.ApplicationStats.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.stats.ApplicationStats.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.stats.ApplicationStats} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.stats.ApplicationStats.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getName();
  if (f.length > 0) {
    writer.writeString(
      1,
      f
    );
  }
  f = message.getStage();
  if (f !== 0.0) {
    writer.writeEnum(
      2,
      f
    );
  }
  f = message.getRelativetime();
  if (f !== 0) {
    writer.writeInt32(
      3,
      f
    );
  }
};


/**
 * @enum {number}
 */
proto.stats.ApplicationStats.Stage = {
  PRE_ON_CREATE: 0,
  CREATED: 1
};

/**
 * optional string name = 1;
 * @return {string}
 */
proto.stats.ApplicationStats.prototype.getName = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 1, ""));
};


/**
 * @param {string} value
 * @return {!proto.stats.ApplicationStats} returns this
 */
proto.stats.ApplicationStats.prototype.setName = function(value) {
  return jspb.Message.setProto3StringField(this, 1, value);
};


/**
 * optional Stage stage = 2;
 * @return {!proto.stats.ApplicationStats.Stage}
 */
proto.stats.ApplicationStats.prototype.getStage = function() {
  return /** @type {!proto.stats.ApplicationStats.Stage} */ (jspb.Message.getFieldWithDefault(this, 2, 0));
};


/**
 * @param {!proto.stats.ApplicationStats.Stage} value
 * @return {!proto.stats.ApplicationStats} returns this
 */
proto.stats.ApplicationStats.prototype.setStage = function(value) {
  return jspb.Message.setProto3EnumField(this, 2, value);
};


/**
 * optional int32 relativeTime = 3;
 * @return {number}
 */
proto.stats.ApplicationStats.prototype.getRelativetime = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 3, 0));
};


/**
 * @param {number} value
 * @return {!proto.stats.ApplicationStats} returns this
 */
proto.stats.ApplicationStats.prototype.setRelativetime = function(value) {
  return jspb.Message.setProto3IntField(this, 3, value);
};


goog.object.extend(exports, proto.stats);
