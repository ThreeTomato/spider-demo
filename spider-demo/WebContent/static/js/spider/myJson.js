/**
 * 前台  js创建对象，转化json
 * 注：前台创建对象对应属性必须与后台接收的vo类属性一致
 */
//全局数组变量
var fieldSearchArr = new Array();

//提供参数 调用创建对象方法
function submit(){
	var obj = createIndexObjec(id, name, age, sex);
	fieldSearchArr.push(obj);
}

//创建对象
function createIndexObjec(id, name, age, sex) {
    var FieldValue = new Object();
    FieldValue.id = id; 
    FieldValue.name = name; 
    FieldValue.age = age; 
    FieldValue.sex = sex; 
    FieldValue.get = function() {};
    return FieldValue;
}
//数组转化为json
$.toJSON(fieldSearchArr);