 $(function() {
     treeGridMdseCatURL = 'treeGridMdseCat.htm' ;//查询
     reserveMdseCatURL = 'reserveMdseCat.htm' ;//修改
     deleteMdseCatURL = 'deleteMdseCat.htm' ;//删除
        init();
    });
var init = function(){
    var o_table = new TableInit();
    o_table.Init();
    var o_btn = new ButtonInit();
    o_btn.Init();
};


 function myvalue(elem, operation, value) {
     //alert("myvalue: "+value);
     if(operation === 'get') {
         return $(elem).val();
     } else if(operation === 'set') {
         $(elem).val(value);
     }
 };
var TableInit = function () {
    var oTable = new Object();
    oTable.Init = function () {
        $.jgrid.defaults.styleUI = 'Bootstrap';
        $("#table_mdse_cat").jqGrid({
            url : treeGridMdseCatURL,
            postData : {
                'parentId' : "-1"
            }, //发送数据
            datatype : "json",
            treeGrid : true,//ture则为树形表格
            treeGridModel : "adjacency",
            ExpandColumn : "mdseCatName",//展开的列
            ExpandColClick : true,//树形表格是否展开
            height : "400",
            autowidth : true,
            colNames : [ '产品分类ID', '父ID', '状态', '商品分类名称', '商品分类编号', '创建时间'],
            colModel : [ {
                name : "id",
                index : "id",
                hidden : false,
                editable : true,
                key : true
            }, {
                name : "parentId",
                index : "parentId",
                hidden : true,
                editable : true,
                editrules : {
                    required : false
                }
            }, {
                name : "state",
                index : "state",
                hidden : true
            }, {
                name : "mdseCatName",
                index : "mdseCatName",
                hidden : false,
                editable : true,
                editrules : {
                    required : true
                }
            }, {
                name : "mdseCatNo",
                index : "mdseCatNo",
                hidden : false,
                editable : true,
                editrules : {
                    required : true
                }
            }, {
                name : "creationTime",
                index : "creationTime",
                hidden : false,
                editable : false,
                formatter:function(value,row,index){
                    return changeDateFormat14(value);
                }
            } ],
            pager : "#pager_mdse_cat",
            viewrecords : true,
            jsonReader : {
                root : "dataRows",
                repeatitems : false
            },
            treeReader : {
                level_field : "level",
                parent_id_field : "parent",
                leaf_field : "isLeaf",
                expanded_field : "expanded"
            },
            sortable : true,
            sortName : "id",
            sortorder : "asc",
            editurl : reserveMdseCatURL
        });
        //---------------------------------

    };

    return oTable;
};

var ButtonInit = function () {
    var btnInit = new Object();
    btnInit.Init = function(){
        // Setup buttons
        var jqnav = $("#table_mdse_cat").jqGrid(
            'navGrid',
            '#pager_mdse_cat',
            {
                add : ($("#add").val() && $("#add").val() == "true"),
                edit : ($("#edit").val() && $("#edit").val() == "true"),
                del : ($("#del").val() && $("#del").val() == "true"),
                search : false,
                refresh : false,
                addtext : "添加",
                edittext : "编辑",
                deltext : "删除"
            },
            {//edit
                height : 400,
                reloadAfterSubmit : true,
                closeAfterEdit : true,
                afterSubmit: function(xhr, postdata) {
                    var obj = eval('(' + xhr.responseText + ')');
                    if(obj.errorMsg){
                        $("#cData").click();
                        layer.alert(obj.errorMsg, {icon: 2});
                        return false;
                    }else{
                        $("#table_mdse_cat").trigger("reloadGrid");
                        $("#cData").click();
                        layer.alert("修改成功!", {icon: 1});
                        return true;
                    }
                }
            },
            {//add
                height : 400,
                reloadAfterSubmit : true,
                beforeShowForm : function(frm) {
                    var ids = $("#table_mdse_cat").jqGrid('getGridParam', 'selrow');
                    if(ids != undefined){
                        frm.find('#parentId').val(parentId.value == '' ? ids : parentId.value);
                    }

                },
                closeAfterAdd : true,
                afterSubmit: function(xhr, postdata) {
                    var obj = eval('(' + xhr.responseText + ')');
                    if(obj.errorMsg){
                        $("#cData").click();
                        layer.alert(obj.errorMsg, {icon: 2});
                        return false;
                    }else{
                        $("#table_mdse_cat").trigger("reloadGrid");
                        $("#cData").click();
                        layer.alert("新增成功!", {icon: 1});
                        return true;
                    }
                }
            },
            {//del
                url : deleteMdseCatURL,
                afterSubmit: function(xhr, postdata) {
                    var obj = eval('(' + xhr.responseText + ')');
                    if(obj.errorMsg){
                        layer.alert(obj.errorMsg, {icon: 2});
                        $("#eData").click();
                        return false;
                    }else{
                        $("#table_mdse_cat").trigger("reloadGrid");
                        $("#eData").click();
                        layer.alert("删除成功!", {icon: 1});
                        return true;
                    }
                }
            },
            {}
        );


/*        $("#add_table_mdse_cat").click(
            function() {
                var ids = $("#table_mdse_cat").jqGrid('getGridParam', 'selrow');
                if (!ids || ids == null) {
                    $("#cData").click();
                    $("#alertmod_table_mdse_cat_mod").show();
                }
            }
        );*/

        $("#alertmod_table_mdse_cat_mod_a").click(function() {
            $("#alertmod_table_mdse_cat_mod").hide();
        });
    };
    return btnInit;
};

$("#table_mdse_cat").on("click", 'tr[role="row"]', function() {
    $("#alertmod_table_mdse_cat_mod").hide();
})
