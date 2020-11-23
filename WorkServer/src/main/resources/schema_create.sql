CREATE TYPE test_type AS ENUM (
    'INSTRUMENTATION'
);

CREATE TYPE screen_orientation AS ENUM (
    'PORTRAIT',
    'LANDSCAPE'
);

CREATE TYPE result_status AS ENUM (
    'STARTED',
    'ERROR',
    'FAILURE',
    'PASSED',
    'ASSUMPTION_FAILURE',
    'IGNORED'
);

CREATE TYPE key_value AS (
    _key VARCHAR,
    _value VARCHAR
);

CREATE TYPE component_name AS (
    package_name VARCHAR,
    class_name VARCHAR
);

CREATE TYPE activity_stage AS ENUM (
    'PRE_ON_CREATE',
    'CREATED',
    'STARTED',
    'RESUMED',
    'PAUSED',
    'STOPPED',
    'RESTARTED',
    'DESTROYED'
);

CREATE TYPE activity_stats AS (
    name VARCHAR,
    activity_stage activity_stage,
    relative_time INT
);


CREATE TYPE app_stage AS ENUM (
    'PRE_ON_CREATE',
    'CREATED'
);

CREATE TYPE app_stats AS (
    name VARCHAR,
    app_stage app_stage,
    relative_time INT
);

CREATE TYPE binder_stats AS (
    death_object_count SMALLINT,
    local_object_count SMALLINT,
    proxy_object_count SMALLINT,
    received_transactions SMALLINT,
    sent_transactions SMALLINT,
    relative_time INT
);

CREATE TYPE frame_stats AS (
    activity_name VARCHAR,
    animation_uration BIGINT,
    command_issue_duration BIGINT,
    draw_duration BIGINT,
    input_handling_duration BIGINT,
    layout_measure_duration BIGINT,
    swap_buffers_duration BIGINT,
    sync_duration BIGINT,
    total_duration BIGINT,
    unknown_delay_duration BIGINT,
    intended_v_sync_timestamp BIGINT,
    v_sync_timestamp BIGINT,
    first_draw_frame BOOLEAN,
    relative_time INT
);

CREATE TYPE gc_stats AS (
    run_count INT,
    run_total_duration INT,
    total_bytes_allocated BIGINT,
    total_bytes_freed BIGINT,
    blocking_run_count INT,
    blocking_run_total_duration INT,
    count_rate_histogram VARCHAR,
    blocking_count_rate_histogram VARCHAR,
    relative_time INT
);

CREATE TYPE vm_props_stats AS (
    properties key_value,
    environment_variables key_value
);

CREATE TYPE cpu_stats AS (
    thread_cpu_time_nanos BIGINT
);

CREATE TYPE thread_state AS ENUM (
    'NEW',
    'RUNNABLE',
    'BLOCKED',
    'WAITING',
    'TIMED_WAITING',
    'TERMINATED'
);

CREATE TYPE thread_info AS (
    id BIGINT,
    name VARCHAR,
    priority INT,
    is_interrupted BOOLEAN,
    is_alive BOOLEAN,
    is_daemon BOOLEAN,
    state thread_state
);

CREATE TYPE thread_stats AS (
    thread_info key_value,
    relative_time INT
);

CREATE TYPE storage_info AS (
    totalSizeBytes BIGINT,
    availableSizeBytes BIGINT
);

CREATE TYPE storage_stats AS (
    internal_storage storage_info,
    external_storage storage_info
);

CREATE TYPE process_stats AS (
    pid INT,
    uid INT,
    exclusive_cores INT[],
    elapsed_cpu_time BIGINT,
    start_elapsed_realtime BIGINT,
    start_uptime_millis BIGINT,
    is_64_bit BOOLEAN
);

CREATE TYPE app_memory AS (
    dalvik_pss INT,
    dalvik_private_dirty INT,
    dalvik_shared_dirty INT,
    native_pss INT,
    native_private_dirty INT,
    native_shared_dirty INT,
    other_pss INT,
    other_private_dirty INT,
    other_shared_dirty INT
);

CREATE TYPE system_memory AS (
    total_size_bytes INT,
    available_size_bytes INT,
    threshold_size_bytes INT
);

CREATE TYPE memory_stats AS (
    app app_memory,
    system system_memory
);

CREATE TYPE battery_status AS ENUM (
    'NO_STATUS',
    'CHARGING',
    'DISCHARGING',
    'NOT_CHARGING',
    'FULL',
    'TERMINATED'
);

CREATE TYPE battery_health AS ENUM (
    'NO_HEALTH',
    'GOOD',
    'OVERHEAT',
    'DEAD',
    'OVER_VOLTAGE',
    'UNSPECIFIED_FAILURE',
    'COLD'
);

CREATE TYPE battery_power_source AS ENUM (
    'NO_SOURCE',
    'NONE',
    'AC_CHARGER',
    'USB_PORT',
    'WIRELESS'
);

CREATE TYPE battery_stats AS (
    is_present BOOLEAN,
    battery_health battery_health,
    level_percentage INT,
    voltage INT,
    temperature_celsius FLOAT,
    technology FLOAT,
    status battery_status,
    power_source battery_power_source
);

CREATE TABLE work(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  key UUID UNIQUE NOT NULL,
  package_ame VARCHAR NOT NULL,
  test_package_name VARCHAR NOT NULL,

  type test_type DEFAULT 'INSTRUMENTATION' NOT NULL,

  timeoutSeconds INT DEFAULT 1800 NOT NULL,
  locale VARCHAR(3) DEFAULT 'US' NOT NULL,
  forced_screen_orientation screen_orientation DEFAULT 'PORTRAIT' NOT NULL,

  environment_variables key_value[] NOT NULL,
  num_retries_per_device SMALLINT DEFAULT 1 NOT NULL,
  performance_monitoring_enabled BOOLEAN DEFAULT TRUE NOT NULL,
  video_recording_enabled BOOLEAN DEFAULT FALSE NOT NULL,

  test_runner_class_name component_name NULL,

  isolation_enabled BOOLEAN DEFAULT FALSE NOT NULL,
  clear_package_data_enabled BOOLEAN DEFAULT FALSE NOT NULL,
  profiling_enabled BOOLEAN DEFAULT TRUE NOT NULL,

  obscure_screen_enabled BOOLEAN DEFAULT FALSE NOT NULL,
  auto_window_shots_enabled BOOLEAN DEFAULT FALSE NOT NULL,

  retrieve_app_files_enabled BOOLEAN DEFAULT FALSE NOT NULL,
  retrieve_test_files_enabled BOOLEAN DEFAULT TRUE NOT NULL,

  created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE auth_model(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  key VARCHAR UNIQUE NOT NULL,
  email VARCHAR UNIQUE NOT NULL,
  phone_number VARCHAR UNIQUE NOT NULL,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NOT NULL
);

CREATE TABLE atomic_test (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    className VARCHAR NOT NULL,
    methodName VARCHAR NOT NULL,
    key VARCHAR NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    work_id BIGINT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES work(id) ON DELETE CASCADE
);

CREATE TABLE remote_file(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    url VARCHAR NOT NULL,
    size_bytes BIGINT NOT NULL,
    last_modified BIGINT NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    work_id BIGINT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES work(id) ON DELETE CASCADE
);

CREATE TABLE atomic_result(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    time_started BIGINT NOT NULL,
    status result_status NOT NULL,
    time_finished BIGINT NOT NULL,
    stack_trace TEXT NOT NULL,
    runtime_logs TEXT[] NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    atomic_test_id BIGINT NOT NULL,
    auth_model_id BIGINT NOT NULL,
    FOREIGN KEY (atomic_test_id) REFERENCES atomic_test(id) ON DELETE CASCADE,
    FOREIGN KEY (auth_model_id) REFERENCES auth_model(id) ON DELETE CASCADE
);

CREATE TABLE vitals(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    reference_time BIGINT NOT NULL,

    vm_props vm_props_stats NOT NULL,
    process_stats process_stats NOT NULL,

    start_storage_stats process_stats NOT NULL,
    end_storage_stats process_stats NOT NULL,

    memory_stats memory_stats[] NOT NULL,
    binder_stats binder_stats[] NOT NULL,
    thread_stats thread_stats[] NOT NULL,
    gc_stats gc_stats[] NOT NULL,

    frame_stats frame_stats[] NOT NULL,
    app_stats app_stats[] NOT NULL,
    activity_stats activity_stats[] NOT NULL,
    atomic_result_id BIGINT NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (atomic_result_id) REFERENCES atomic_result(id) ON DELETE CASCADE
);

CREATE TABLE work_assignment(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    last_updated timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    auth_model_id BIGINT NOT NULL,
    work_id BIGINT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES work(id) ON DELETE CASCADE,
    FOREIGN KEY (auth_model_id) REFERENCES auth_model(id) ON DELETE CASCADE
);