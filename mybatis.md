# foreach 使用
## 描述
| 属性 | 描述 |
| ------ | ------ |
|item	|循环体中的具体对象。支持属性的点路径访问，如item.age,item.info.details。 具体说明：在list和数组中是其中的对象，在map中是value。 该参数为必选。
|collection|	要做foreach的对象，作为入参时，List<?>对象默认用list代替作为键，数组对象有array代替作为键，Map对象用map代替作为键。 当然在作为入参时可以使用@Param("keyName")来设置键，设置keyName后，list,array,map将会失效。 除了入参这种情况外，还有一种作为参数对象的某个字段的时候。举个例子： 如果User有属性List ids。入参是User对象，那么这个collection = "ids" 如果User有属性Ids ids;其中Ids是个对象，Ids有个属性List id;入参是User对象，那么collection = "ids.id" 上面只是举例，具体collection等于什么，就看你想对那个元素做循环。 该参数为必选。
|separator|	元素之间的分隔符，例如在in()的时候，separator=","会自动在元素中间用“,“隔开，避免手动输入逗号导致sql错误，如in(1,2,)这样。该参数可选。
|open	|foreach代码的开始符号，一般是(和close=")"合用。常用在in(),values()时。该参数可选。
|close	|foreach代码的关闭符号，一般是)和open="("合用。常用在in(),values()时。该参数可选。
|index	|在list和数组中,index是元素的序号，在map中，index是元素的key，该参数可选。

## 遍历map 的key
```
<foreach item="value" index="key" collection="row" open="(" close=")" separator=",">
    ${key}
</foreach> 
```
或
```
<foreach item="value" index="key" collection="row.keys" open="(" close=")" separator=",">
    ${value}
</foreach>
```

## 遍历map的value
```$xslt
<foreach item="value" index="key" collection="row.values" open="(" close=")" separator=",">
    #{value}
</foreach>
```
或

```$xslt
<foreach item="value" index="key" collection="row" open="(" close=")" separator=",">
    #{value}
</foreach>
```

# 批量处理
>https://blog.csdn.net/lwpczy1/article/details/79158535
