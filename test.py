import pyarrow as pa

tb_u_basic_info = [
    pa.field("id", pa.int64()),
    pa.field("user_id", pa.int64()),
    pa.field("username", pa.string()),
    pa.field("ktp_name", pa.string()),
    pa.field("ktp_no", pa.string()),
    pa.field("ktp_photo", pa.string()),
    pa.field("big_head_photo", pa.string()),
    pa.field("email", pa.string()),
    pa.field("ktp_province", pa.string()),
    pa.field("ktp_city", pa.string()),
    pa.field("ktp_district", pa.string()),
    pa.field("ktp_address", pa.string()),
    pa.field("user_type", pa.int8()),
    pa.field("on_off", pa.string()),
    pa.field("status", pa.int8()),
    pa.field("audit_result_status", pa.int8()),
    pa.field("audit_result_msg", pa.string()),
    pa.field("auditor_id", pa.int64()),
    pa.field("auth_state", pa.int8()),
    pa.field("auth_state_msg", pa.string()),
    pa.field("auth_channel", pa.int8()),
    pa.field("inserttime", pa.int64()),
    pa.field("updatetime", pa.int64()),
    pa.field("isactive", pa.bool_()),
]

