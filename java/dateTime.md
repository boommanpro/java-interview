## JDK8关于时间的注解

1.时间类型

LocalTime       HH:mm:ss
LocalDateTime   yyyy-MM-dd HH:mm:ss

2.注解

1.从SpringMVC接受数据

@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

2.返回格式化后的数据

jackson  || fastjson有自己的
@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")

3.可能会用到的  ES --- mysql 存放数据

@JsonDeserialize(using = LocalDateTimeDeserializer.class)
@JsonSerialize(using = LocalDateTimeSerializer.class)
@Field(index = false, type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")