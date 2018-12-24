var proAndIdDatas;
layui.use(['layer'], function(){
    var layer = layui.layer;
});
$(function () {

    ajaxGetProAndId();

    initTable();

    //获取全部项目设备列表
    getTotalData();


    $("form").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            pro: {
                message: '项目显示名称验证失败',
                validators: {
                    notEmpty: {
                        message: '项目显示名称不能为空'
                    }
                }
            },
            pro_name: {
                message: '项目配置名称验证失败',
                validators: {
                    notEmpty: {
                        message: '项目配置名称不能为空'
                    }
                }
            },
            device_id: {
                message: '设备id验证失败',
                validators: {
                    notEmpty: {
                        message: '设备id不能为空'
                    }
                }
            },
            fields_config: {
                message: '字段配置验证失败',
                validators: {
                    notEmpty: {
                        message: '字段配置不能为空'
                    }
                }
            },
            command_name: {
                message: '命令名称验证失败',
                validators: {
                    notEmpty: {
                        message: '命令名称不能为空'
                    }
                }
            },
            command_content: {
                message: '命令内容验证失败',
                validators: {
                    notEmpty: {
                        message: '命令内容不能为空'
                    }
                }
            },
            reply_content: {
                message: '回复内容验证失败',
                validators: {
                    notEmpty: {
                        message: '回复内容不能为空'
                    }
                }
            }
        }
    });

    //pro modal 初始化
    initProModal();
    //command modal 初始化
    initCommandModal();


})

/**
 * table 初始化
 */
function initTable() {

    //table操作列
    var operateFormatter = function (value, row, index) {//赋予的参数
        return [
            '<button class="btn btn-primary btn-sm rightSize detailBtn" type="button" onclick="detailsClick(this)"><i class="fa"></i>详情</button>' +
            '<button class="btn btn-warning btn-sm rightSize packageBtn" type="button" onclick="issueClick(this)"><i class="fa"></i>命令</button>' +
            '<button class="btn btn-danger btn-sm rightSize packageBtn" type="button" onclick="deleteClick(this)"><i class="fa"></i>删除</button>'

        ].join('');
    };

    //初始化table
    $('#table').bootstrapTable('destroy').bootstrapTable({
        data: "",
        dataType: "json",
        contentType: 'application/json,charset=utf-8',
        toolbar: "#toolbar",
        uniqueId: "deviceId",
        sortName: 'SerialNumber',
        sidePagination: "client",
        cache: false,
        striped: true, // 是否显示行间隔色
        pagination: true, // 是否分页
        pageNumber: 1,
        pageSize: "10",
        pageList: [10, 25, 50, 100],
        paginationPreText: "Previous",
        paginationNextText: "Next",
        paginationFirstText: "First",
        paginationLastText: "Last",
        columns: [
            {
                field: 'SerialNumber',
                title: '序号',
                align: 'center',
                formatter: function (value, row, index) {
                    return index+1;
                }
            }, {
                field: 'pro',
                title: '项目',
                align: 'center',
                sortable:false   //本列不可以排序
            }, {
                field: 'proAndId',
                title: '设备id',
                align: 'center',
                sortable:false
            }, {
                field: 'ts',
                title: '时间',
                align: 'center',
                sortable:false
            }, {
                field: 'status',
                title: '状态',
                align: 'center',
                sortable:false
            }, {
                field: 'electricity',
                title: '电量',
                align: 'center',
                sortable: false
            }, {
                field: 'power',
                title: '功率',
                align: 'center',
                sortable: false
            },
            // {
            //     field: 'details',
            //     title: '详情',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: detailsFormatter //自定义方法，添加操作按钮
            // },
                {
                field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                formatter: operateFormatter //自定义方法，添加操作按钮
            },
            // {
            //     field: 'operate',
            //     title: '删除',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: deleteFormatter //自定义方法，添加操作按钮
            // }
        ]
    });
}

/**
 * 同步获取项目和设备信息
 */
function ajaxGetProAndId() {

    $.ajax({
        url: "/proAndId",
        type: "get",
        async: false,
        success: function (data) {
            proAndIdDatas = data;
            putProSelect();
            putCommandProSelect();
        }
    })
}

/**
 * 填充项目下拉框
 */
function putProSelect() {
    //填充 index页面 项目下拉框
    $("#pro-select").find("option").remove();
    $("<option value='0'>项目</option>").appendTo("#pro-select");
    for (var key in proAndIdDatas) {
        $("<option value="+key+">"+key+"</option>").appendTo("#pro-select");
    }
}

/**
 * 填充命令项目下拉框
 */
function putCommandProSelect() {
    //填充 配置命令 modal项目下拉框
    $("#command_pro_select").find("option").remove();
    for (var key in proAndIdDatas) {
        $("<option value="+key+">"+key+"</option>").appendTo("#command_pro_select");
    }
    $("#command_device_select").find("option").remove();
    if (0 != $("#command_pro_select").find("option").length) {
        var deviceIds = proAndIdDatas[$("#command_pro_select").find("option")[0].value];
        $.each(deviceIds, function (key, value) {
            $("<option value="+value+">"+value+"</option>").appendTo("#command_device_select");
        });
    }
}

/**
 * 项目下拉框更改触发事件
 */
function changeProSelect(obj) {
    var key = $("#pro-select").find("option")[obj.selectedIndex].value;
    $("#device-select").find("option").remove();
    $("<option value=0>设备id</option>").appendTo("#device-select");
    var deviceIds = proAndIdDatas[key];
    $.each(deviceIds, function (key, value) {
        $("<option value="+value+">"+value+"</option>").appendTo("#device-select");
    });
    var para = {};
    para["proAndIds"] = deviceIds.join(",");
    loadTable(para);
}

/**
 * 命令modal项目下拉框更改触发事件
 */
function changeCommandProSelect(obj) {
    var key = $("#command_pro_select").find("option")[obj.selectedIndex].value;
    $("#command_device_select").find("option").remove();
    var deviceIds = proAndIdDatas[key];
    $.each(deviceIds, function (key, value) {
        $("<option value="+value+">"+value+"</option>").appendTo("#command_device_select");
    });
}

/**
 * 设备下拉框更改触发事件
 */
function changeDeviceSelect(obj) {
    var key = $("#device-select").find("option")[obj.selectedIndex].value;
    if ("0" != key) {
        var para = {}
        para["proAndIds"] = key;
        loadTable(para);
    }
}

/**
 * 获取全部项目及设备列表
 */
function getTotalData() {
    var para = {};
    para["proAndIds"] = "";
    loadTable(para);
}

/**
 * 根据设备id加载列表
 * @param para
 */
function loadTable(para) {
    $.ajax({
        url : "/data",
        type: "get",
        data: para,
        async: false,
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            $('#table').bootstrapTable('load', data.rows);
        }
    })
}

/**
 * 提交项目表单
 */
var indexSumbitProForm;
function sumbitProForm() {
    var proForm = $("#pro_form");
    // proForm.data("bootstrapValidator").validate();
    var isValid = proForm.data("bootstrapValidator").isValid();
    if (isValid) {
        $.ajax({
            url: '/data',
            type: "post",
            data: arrayToJson($('#pro_form').serializeArray()),
            async: false,
            contentType:"application/json",
            beforeSend:function()
            {
                //layer loading
                indexSumbitProForm = layer.load(1, {
                    shade: [0.1,'#fff'] //0.1透明度的白色背景
                });
            },
            success: function (data) {
                //layer 关闭loading
                layer.close(indexSumbitProForm);
                if ("success" == data) {
                    // location.reload();
                    getTotalData();
                    putProSelect();
                    $('#addProModal').modal('hide');
                }else if("failed" == data) {
                    layer.msg('新增项目失败');
                }else if ("repeat" == data) {
                    layer.msg("项目名与设备id名称重复，请重新输入")
                }
            }
        })
    }
}

/**
 * 提交命令配置表单
 */
var indexSumbitCommandForm;
function sumbitCommandForm() {
    var proForm = $("#command_form");
    proForm.data("bootstrapValidator").validate();
    var isValid = proForm.data("bootstrapValidator").isValid();
    if (isValid) {
        var data = $('#command_form').serializeArray();
        var proAndId = {name: "proAndId", value: $("#command_device_select").val()};
        data.push(proAndId);
        $.ajax({
            url: '/command',
            type: "post",
            data: arrayToJson(data),
            async: false,
            contentType:"application/json",
            beforeSend:function() {
                //layer loading
                indexSumbitCommandForm = layer.load(2, {
                    shade: [0.1,'#fff'] //0.1透明度的白色背景
                });
            },
            success: function (data) {
                //layer 关闭loading
                layer.close(indexSumbitCommandForm);
                if ("success" == data) {
                    location.reload();
                    putProSelect();
                }else if("failed" == data) {
                    layer.msg('新增命令失败');
                }else if ("repeat" == data) {
                    layer.msg('命令内容重复, 请重新填写');
                }
            },
            error: function () {
                //layer 关闭loading
                layer.close(2);
            }
        })
    }
}

/**
 * 初始化pro modal
 */
function initProModal() {
    //modal
    $('#addProModal').modal({
        backdrop: false
    });
    $('#addProModal').modal('hide');

    $('#addProModal').on('show.bs.modal', function () {
        $("#pro").val("");
        $("#pro_name").val("");
        $("#device_id").val("");
        $("#fields_config").val("");
    });
}

/**
 * 初始化command Modal
 */
function initCommandModal() {
    //modal
    $('#commandModal').modal({
        backdrop: false
    });

    $('#commandModal').modal('hide');

    $('#commandModal').on('show.bs.modal', function () {
        $("#command_name").val("");
        $("#command_content").val("");
        $("#reply_content").val("");
        $("#command_pro_select").find("option").remove();
        $("#command_device_select").find("option").remove();
        putCommandProSelect();
    });
}
/**
 * formArray转换成Json格式
 * @param formArray
 * @returns {string}
 */
function arrayToJson(formArray){
    var dataArray = {};
    $.each(formArray,function(){
        if(dataArray[this.name]){
            if(!dataArray[this.name].push){
                dataArray[this.name] = [dataArray[this.name]];
            }
            dataArray[this.name].push(this.value || '');
        }else{
            dataArray[this.name] = this.value || '';
        }
    });
    return JSON.stringify(dataArray);
}

/**
 * 重置初始化table
 */
function resetTable() {
    getTotalData();
    $("#device-select").find("option").remove();
    $("#device-select").html("<option value=0>设备id</option>")
    putProSelect()
}

/**
 * 详情点击按钮
 * @param obj
 */
function detailsClick(obj) {
    //modal
    $('#detailsModal').modal({
        backdrop: false
    });
    $('#detailsModal').modal('hide');
    var proAndId = obj.parentElement.parentElement.cells[2].innerHTML;
    $.ajax({
        url: '/details/'+proAndId,
        type: "get",
        async: false,
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            var html = "";
            for (var key in data) {
                html = html + "<div class='form-group'>\n" +
                    "                    <label class='col-sm-4 control-label'>"+key+":</label>\n" +
                    "                    <label class='col-sm-3 control-label'>"+data[key]+"</label>\n" +
                    "                </div>";
            }
            if ("" == html) {
                html = html + "数据库中没有配置字段信息";
            }
            $("#detailsModal .modal-body").html(html);
            $("#detailsModal .modal-title").html(proAndId+"数据详情");
            $("#detailsModal").modal("show");
        }
    });
}

/**
 * 下发命令点击按钮
 * @param obj
 */
function issueClick(obj) {
    //modal
    $('#issueCommandModal').modal({
        backdrop: false
    });
    $('#issueCommandModal').modal('hide');
    var proAndId = obj.parentElement.parentElement.cells[2].innerHTML;
    $.ajax({
        url: '/commands/'+proAndId,
        type: "get",
        async: false,
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            var html = "";
            for (var key in data) {
                html = html + "<option value="+data[key].command_content+">"+data[key].command_name+"</option>\n";
            }
            $("#command_list_select").html(html);
            $("#issueCommandModal .modal-title").html(proAndId+"命令列表");
            $("#issueCommandModal #hidden_pro_and_id").html(proAndId);
            $("#issueCommandModal").modal("show");
        }
    });
}

/**
 * 删除点击按钮
 * @param obj
 */
function deleteClick(obj) {
    var proAndId = $("#issueCommandModal #hidden_pro_and_id").html();
    var command = $("#command_list_select").val();

}

/**
 * 命令modal 下发点击按钮
 * @param obj
 */
var indexCommand;
function doCommmand(obj) {
    var proAndId = $("#issueCommandModal #hidden_pro_and_id").html();
    var command = $("#command_list_select").val();
    $.ajax({
        url: '/issue/'+proAndId+"/"+command,
        type: 'get',
        async: false,
        beforeSend:function() {
            //layer loading
            indexCommand = layer.load(3, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
        },
        success: function (data) {
            //layer 关闭loading
            layer.close(indexCommand);
            if ("success" == data) {
                layer.msg("命令下发成功");
                $("#issueCommandModal").modal('hide');
            }else if ("timeout" == data) {
                layer.msg("接收客户端返回信息超时，请重试");
            }else if ("not connected" == data) {
                layer.msg("客户端未连接，请检查后重试");
            }else if ("isLocked" == data) {
                layer.msg("客户端正在等待其他命令回复，请稍后重试");
            }else if ("timeOut" == data) {
                layer.msg("客户端回应超时，请重试");
            }else if ("no reply" == data) {
                layer.msg("数据库中缺少返回值")
            }
        }
    })
}

/**
 * 命令删除
 * @param obj
 */
var indexDeleteCommand = null;
function deleteCommand (obj){
    var proAndId = $("#issueCommandModal #hidden_pro_and_id").html();
    var command = $("#command_list_select").val();
    $.ajax({
        url: '/command/'+proAndId+"/"+command,
        type: 'get',
        async: false,
        beforeSend:function() {
            //layer loading
            indexDeleteCommand = layer.load(3, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
        },
        success: function (data) {
            //layer 关闭loading
            layer.close(indexDeleteCommand);
            if ("success" == data) {
                $("#command_list_select").
                layer.msg("命令删除成功");
                $("#command_list_select option[value='"+command+"']").remove();
            }else if ("failed" == data) {
                layer.msg("命令删除失败");
            }
        }
    })
}