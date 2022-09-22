"use strict";(self["webpackChunkvuehr"]=self["webpackChunkvuehr"]||[]).push([[860],{1546:function(e,t,l){l.r(t),l.d(t,{default:function(){return N}});var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("el-tabs",{attrs:{type:"card"},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[l("el-tab-pane",{attrs:{label:"部门管理",name:"first"}},[l("DeptManage")],1),l("el-tab-pane",{attrs:{label:"职位管理",name:"second"}},[l("PosManage")],1),l("el-tab-pane",{attrs:{label:"职称管理",name:"third"}},[l("JobLevel")],1),l("el-tab-pane",{attrs:{label:"奖惩规则",name:"fourth"}},[l("EcManage")],1),l("el-tab-pane",{attrs:{label:"权限组",name:"fifth"}},[l("PermissManage")],1)],1)],1)},a=[],s=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"470px"}},[l("el-input",{attrs:{placeholder:"输入部门名称进行搜索","prefix-icon":"el-icon-search"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),l("el-tree",{ref:"tree",staticClass:"filter-tree",attrs:{data:e.depts,"expand-on-click-node":!1,props:e.defaultProps,"filter-node-method":e.filterNode},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.node,a=t.data;return l("span",{staticClass:"custom-tree-node",staticStyle:{display:"flex","justify-content":"space-between",width:"100%"}},[l("span",[e._v(e._s(i.label))]),l("span",[l("el-button",{staticClass:"btn",attrs:{type:"primary",size:"mini"},on:{click:function(){return e.addDept(a)}}},[e._v(" 添加部门 ")]),l("el-button",{staticClass:"btn",attrs:{type:"danger",size:"mini"},on:{click:function(){return e.doDeleteDept(a)}}},[e._v(" 删除部门 ")])],1)])}}])})],1),l("div",[l("el-dialog",{attrs:{title:"添加部门",visible:e.dialogVisible,width:"30%","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[l("div",{staticStyle:{width:"90%"}},[l("el-form",{ref:"form",attrs:{"label-position":"left",model:e.dept,"label-width":"80px"}},[l("el-form-item",{attrs:{label:"上级部门"}},[l("el-input",{attrs:{disabled:"true"},model:{value:e.pname,callback:function(t){e.pname=t},expression:"pname"}})],1),l("el-form-item",{attrs:{label:"部门名称"}},[l("el-input",{attrs:{placeholder:"请输入部门名称"},model:{value:e.dept.name,callback:function(t){e.$set(e.dept,"name",t)},expression:"dept.name"}})],1)],1)],1),l("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),l("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.doAdd}},[e._v("确 定")])],1)])],1)])},n=[],o={name:"DeptManage",data(){return{loading:!1,dept:{name:"",parentid:""},pname:"",dialogVisible:!1,filterText:"",depts:[],defaultProps:{children:"children",label:"name"}}},watch:{filterText(e){this.$refs.tree.filter(e)}},mounted(){this.initDepts()},methods:{flushDeleteDep(e,t,l){for(let i=0;i<t.length;i++){let a=t[i];if(a.id==l)return t.splice(i,1),void(0==t.length&&(e.isParent=0));this.flushDeleteDep(a,a.children,l)}},flushAddDep(e,t){for(let l=0;l<e.length;l++){let i=e[l];if(i.id==t.parentid)return i.children=i.children.concat(t),void(i.children.length>0&&(i.isParent=1));this.flushAddDep(i.children,t)}},doAdd(){this.loading=!0,this.postRequest("/system/basic/dept/",this.dept).then((e=>{this.loading=!1,e&&(this.dialogVisible=!1,this.pname="",this.dept.name="",this.dept.parentid="",this.flushAddDep(this.depts,e.data))}))},addDept(e){this.dialogVisible=!0,this.pname=e.name,this.dept.parentid=e.id},doDeleteDept(e){1!=e.isParent?this.$confirm("此操作将永久删除【"+e.name+"】部门, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.loading=!0,this.deleteRequest("/system/basic/dept/"+e.id).then((t=>{this.loading=!1,t&&this.flushDeleteDep(null,this.depts,e.id)}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})})):this.$message.error("该部门下有子部门，删除失败！")},filterNode(e,t){return!e||-1!==t.name.indexOf(e)},initDepts(){this.loading=!0,this.getRequest("/system/basic/dept/").then((e=>{this.loading=!1,e&&(this.depts=e.data)}))}}},r=o,d=l(1001),c=(0,d.Z)(r,s,n,!1,null,"19493e72",null),u=c.exports,h=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[e._v(" 奖惩规则 ")])},p=[],m={name:"EcManage"},f=m,g=(0,d.Z)(f,h,p,!1,null,"1792ffbb",null),b=g.exports,v=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("div",[l("el-input",{staticStyle:{width:"300px"},attrs:{size:"small","prefix-icon":"el-icon-circle-plus-outline",placeholder:"添加职位"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.addJl.apply(null,arguments)}},model:{value:e.jl.name,callback:function(t){e.$set(e.jl,"name",t)},expression:"jl.name"}}),l("el-select",{staticStyle:{"margin-left":"7px","margin-right":"7px"},attrs:{placeholder:"职称等级",size:"small"},model:{value:e.jl.titleLevel,callback:function(t){e.$set(e.jl,"titleLevel",t)},expression:"jl.titleLevel"}},e._l(e.titleLevels,(function(e){return l("el-option",{key:e,attrs:{label:e,value:e}})})),1),l("el-button",{attrs:{type:"primary",icon:"el-icon-circle-plus-outline",size:"small",loading:e.loading},on:{click:e.addJl}},[e._v("添加 ")])],1),l("div",[l("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"70%","margin-top":"10px"},attrs:{data:e.jls,stripe:"",border:"",size:"medium"},on:{"selection-change":e.handleSelectionChange}},[l("el-table-column",{attrs:{type:"selection",width:"55"}}),l("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),l("el-table-column",{attrs:{prop:"name",label:"职称名称",width:"150"}}),l("el-table-column",{attrs:{prop:"titleLevel",label:"职称级别"}}),l("el-table-column",{attrs:{prop:"enabled",label:"是否启用"},scopedSlots:e._u([{key:"default",fn:function(t){return[1==t.row.enabled?l("el-tag",{attrs:{type:"success"}},[e._v("已启用")]):l("el-tag",{attrs:{type:"danger"}},[e._v("未启用")])]}}])}),l("el-table-column",{attrs:{prop:"createDate",label:"创建时间"}}),l("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{size:"mini"},on:{click:function(l){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑 ")]),l("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(l){return e.handleDelete(t.$index,t.row)}}},[e._v("删除 ")])]}}])})],1)],1),l("div",[l("el-dialog",{attrs:{title:"职称管理",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[l("el-form",{ref:"JlForm",attrs:{model:e.updateJls,rules:e.rules}},[l("el-form-item",{attrs:{label:"编号","label-width":e.formLabelWidth}},[l("el-input",{attrs:{disabled:!0,autocomplete:"off"},model:{value:e.updateJls.id,callback:function(t){e.$set(e.updateJls,"id",t)},expression:"updateJls.id"}})],1),l("el-form-item",{attrs:{label:"职称名称","label-width":e.formLabelWidth,prop:"name"}},[l("el-input",{attrs:{autocomplete:"off"},model:{value:e.updateJls.name,callback:function(t){e.$set(e.updateJls,"name",t)},expression:"updateJls.name"}})],1),l("el-form-item",{attrs:{label:"职称级别","label-width":e.formLabelWidth}},[l("el-select",{staticStyle:{"margin-left":"7px","margin-right":"7px"},attrs:{placeholder:e.updateJls.titleLevel,size:"small"},model:{value:e.updateJls.titleLevel,callback:function(t){e.$set(e.updateJls,"titleLevel",t)},expression:"updateJls.titleLevel"}},e._l(e.titleLevels,(function(e){return l("el-option",{key:e,attrs:{label:e,value:e}})})),1)],1),l("el-form-item",{attrs:{label:"是否启用","label-width":e.formLabelWidth}},[l("el-switch",{attrs:{"active-value":1,"inactive-value":0,"active-text":"已启用","inactive-text":"禁用"},model:{value:e.updateJls.enabled,callback:function(t){e.$set(e.updateJls,"enabled",t)},expression:"updateJls.enabled"}})],1),l("el-form-item",{attrs:{label:"创建时间","label-width":e.formLabelWidth}},[l("el-input",{attrs:{disabled:!0,autocomplete:"off"},model:{value:e.updateJls.createDate,callback:function(t){e.$set(e.updateJls,"createDate",t)},expression:"updateJls.createDate"}})],1)],1),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),l("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.doUpdate}},[e._v("确 定")])],1)],1)],1),l("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",size:"small",disabled:0==e.multipleSelection.length,loading:e.loading},on:{click:e.deleteMany}},[e._v("批量删除 ")])],1)},y=[],x={name:"JobLevel",data(){return{loading:!1,dialogFormVisible:!1,formLabelWidth:"120px",multipleSelection:[],jl:{name:"",titleLevel:""},jls:[],updateJls:{id:"",name:"",titleLevel:"",enabled:"",createDate:""},rules:{name:[{required:!0,message:"请输入职称名称",trigger:"blur"},{pattern:"^[一-龥_a-zA-Z0-9]+$",message:"请填写正确的职称名称",trigger:"blur"}]},titleLevels:["正高级","副高级","中级","初级","员级"]}},mounted(){this.initJls()},methods:{deleteMany(){this.loading=!0;let e="";this.multipleSelection.forEach((t=>{e+="ids="+t.id+"&"})),this.deleteRequest("/system/basic/jl/?"+e).then((e=>{this.loading=!1,e&&this.initJls()}))},doUpdate(){this.$refs.JlForm.validate((e=>{if(!e)return this.$message.error("字段不合法！"),!1;this.loading=!0,this.putRequest("/system/basic/jl/",this.updateJls).then((e=>{this.loading=!1,e&&(this.initJls(),this.dialogFormVisible=!1)}))}))},addJl(){this.jl.name&&this.jl.titleLevel?(this.loading=!0,this.postRequest("/system/basic/jl/",this.jl).then((e=>{this.loading=!1,e&&(this.initJls(),this.jl.name="",this.jl.titleLevel="")}))):this.$message.error("请完整填写职位名称和职位等级！")},handleEdit(e,t){Object.assign(this.updateJls,t),this.dialogFormVisible=!0},handleDelete(e,t){this.$confirm("此操作将永久删除【"+t.name+"】职称, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.loading=!0,this.deleteRequest("/system/basic/jl/"+t.id).then((e=>{this.loading=!1,e&&this.initJls()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},handleSelectionChange(e){this.multipleSelection=e},initJls(){this.loading=!0,this.getRequest("/system/basic/jl/").then((e=>{this.loading=!1,e&&(this.jls=e.data)}))}}},k=x,_=(0,d.Z)(k,v,y,!1,null,"2f5bc562",null),w=_.exports,$=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("div",{staticClass:"permissAddInput"},[l("el-input",{attrs:{size:"small",placeholder:"请输入角色英文名"},model:{value:e.role.name,callback:function(t){e.$set(e.role,"name",t)},expression:"role.name"}},[l("template",{slot:"prepend"},[e._v("ROLE_")])],2),l("el-input",{attrs:{size:"small",placeholder:"请输入角色中文名"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.doAdd.apply(null,arguments)}},model:{value:e.role.namezh,callback:function(t){e.$set(e.role,"namezh",t)},expression:"role.namezh"}}),l("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-circle-plus-outline",loading:e.loading},on:{click:e.doAdd}},[e._v("添加")])],1),l("div",{staticStyle:{"margin-top":"12px",width:"700px"}},e._l(e.roles,(function(t,i){return l("el-collapse",{key:i,attrs:{accordion:""},on:{change:e.change},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[l("el-collapse-item",{attrs:{title:t.namezh,name:t.id}},[l("el-card",{staticClass:"box-card",attrs:{shadow:"hover"}},[l("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[l("span",[e._v("可访问的资源")]),l("el-button",{staticStyle:{float:"right",padding:"3px 0",color:"crimson","font-size":"smaller"},attrs:{icon:"el-icon-delete",type:"text"},on:{click:function(l){return e.deleteRole(t)}}},[e._v("删除 ")])],1),l("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]},[l("el-tree",{key:i,ref:"tree",refInFor:!0,attrs:{"show-checkbox":"",data:e.menus,"node-key":"id","default-checked-keys":e.selectedMenus,props:e.defaultProps}}),l("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[l("el-button",{on:{click:e.cancelUpdate}},[e._v("取消修改")]),l("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:function(l){return e.doUpdate(t.id,i)}}},[e._v("确认修改")])],1)],1)])],1)],1)})),1)])},R=[],S={name:"PermissManage",data(){return{loading:!1,activeName:-1,selectedMenus:[],defaultProps:{children:"children",label:"name"},menus:[],roles:[],role:{name:"",namezh:""}}},mounted(){this.initRoles()},methods:{deleteRole(e){this.$confirm("此操作将永久删除【"+e.namezh+"】角色, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.loading=!0,this.deleteRequest("/system/basic/permiss/deleteRole/"+e.id).then((e=>{this.loading=!1,e&&this.initRoles()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},doAdd(){this.role.name&&this.role.namezh?(this.loading=!0,this.postRequest("/system/basic/permiss/addRole/",this.role).then((e=>{this.loading=!1,e&&(this.role.name="",this.role.namezh="",this.initRoles())}))):this.$message.error("数据不能为空！")},cancelUpdate(){this.activeName=-1},change(e){e&&(this.initMenus(),this.initSelectedMenus(e))},doUpdate(e,t){let l=this.$refs.tree[t],i=l.getCheckedKeys(!0),a="/system/basic/permiss/?rid="+e;i.forEach((e=>{a+="&mids="+e})),this.loading=!0,this.putRequest(a).then((e=>{this.loading=!1,e&&(this.activeName=-1)}))},initSelectedMenus(e){this.loading=!0,this.getRequest("/system/basic/permiss/mids/"+e).then((e=>{this.loading=!1,e&&(this.selectedMenus=e.data)}))},initMenus(){this.loading=!0,this.getRequest("/system/basic/permiss/menu").then((e=>{this.loading=!1,e&&(this.menus=e.data)}))},initRoles(){this.loading=!0,this.getRequest("/system/basic/permiss/").then((e=>{this.loading=!1,e&&(this.roles=e.data)}))}}},P=S,z=(0,d.Z)(P,$,R,!1,null,"16f2009a",null),D=z.exports,J=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("div",[l("el-input",{staticStyle:{width:"300px","margin-right":"8px"},attrs:{size:"small",placeholder:"添加职位","prefix-icon":"el-icon-circle-plus-outline"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.addPos.apply(null,arguments)}},model:{value:e.pos.name,callback:function(t){e.$set(e.pos,"name",t)},expression:"pos.name"}}),l("el-button",{attrs:{icon:"el-icon-circle-plus-outline",size:"small",type:"primary",loading:e.loading},on:{click:e.addPos}},[e._v("添加")])],1),l("div",{staticClass:"posManageMain"},[l("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"70%"},attrs:{data:e.positions,stripe:"",border:"",size:"medium"},on:{"selection-change":e.handleSelectionChange}},[l("el-table-column",{attrs:{type:"selection",width:"55"}}),l("el-table-column",{attrs:{prop:"id",label:"编号",width:"70"}}),l("el-table-column",{attrs:{prop:"name",label:"职位名称",width:"200"}}),l("el-table-column",{attrs:{prop:"enabled",label:"是否启用",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[1==t.row.enabled?l("el-tag",{attrs:{type:"success",size:"small"}},[e._v("已启用")]):l("el-tag",{attrs:{type:"danger",size:"small"}},[e._v("禁用")])]}}])}),l("el-table-column",{attrs:{prop:"createDate",label:"创建日期",width:"170"}}),l("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{size:"mini"},on:{click:function(l){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑 ")]),l("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(l){return e.handleDelete(t.$index,t.row)}}},[e._v("删除 ")])]}}])})],1)],1),l("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",size:"small",disabled:0==e.multipleSelection.length},on:{click:e.deleteMany}},[e._v("批量删除 ")]),l("div",[l("el-dialog",{attrs:{title:"职位修改",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[l("el-form",{attrs:{model:e.pos}},[l("el-form-item",{attrs:{label:"编号","label-width":e.formLabelWidth}},[l("el-input",{attrs:{disabled:!0,autocomplete:"false"},model:{value:e.updatePos.id,callback:function(t){e.$set(e.updatePos,"id",t)},expression:"updatePos.id"}})],1),l("el-form-item",{attrs:{label:"职位名称","label-width":e.formLabelWidth}},[l("el-input",{attrs:{autocomplete:"false"},model:{value:e.updatePos.name,callback:function(t){e.$set(e.updatePos,"name",t)},expression:"updatePos.name"}})],1),l("el-form-item",{attrs:{label:"是否启用","label-width":e.formLabelWidth}},[l("el-switch",{attrs:{"active-value":1,"inactive-value":0,"active-text":"已启用","inactive-text":"禁用"},model:{value:e.updatePos.enabled,callback:function(t){e.$set(e.updatePos,"enabled",t)},expression:"updatePos.enabled"}})],1),l("el-form-item",{attrs:{label:"创建日期","label-width":e.formLabelWidth}},[l("el-input",{attrs:{disabled:!0,autocomplete:"false"},model:{value:e.updatePos.createDate,callback:function(t){e.$set(e.updatePos,"createDate",t)},expression:"updatePos.createDate"}})],1)],1),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),l("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.doUpdate}},[e._v("确 定")])],1)],1)],1)],1)},C=[],L={name:"PosManage",data(){return{loading:!1,dialogFormVisible:!1,formLabelWidth:"100px",multipleSelection:[],pos:{name:""},updatePos:{name:"",id:"",enabled:"",createDate:""},positions:[]}},methods:{deleteMany(){this.$confirm("此操作将永久删除【"+this.multipleSelection.length+"】条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{let e="";this.multipleSelection.forEach((t=>{e+="ids="+t.id+"&"})),this.loading=!0,this.deleteRequest("/system/basic/pos/?"+e).then((e=>{this.loading=!1,e&&this.initPositions()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},handleSelectionChange(e){this.multipleSelection=e},doUpdate(){this.loading=!0,this.putRequest("/system/basic/pos/",this.updatePos).then((e=>{this.loading=!1,e&&(this.initPositions(),this.dialogFormVisible=!1)}))},addPos(){this.pos.name?(this.loading=!0,this.postRequest("/system/basic/pos/",this.pos).then((e=>{this.loading=!1,e&&(this.initPositions(),this.pos.name="")}))):this.$message.error("请输入职位名称！")},initPositions(){this.loading=!0,this.getRequest("/system/basic/pos/").then((e=>{this.loading=!1,e&&(this.positions=e.data)}))},handleEdit(e,t){this.dialogFormVisible=!0,Object.assign(this.updatePos,t)},handleDelete(e,t){this.$confirm("此操作将永久删除【"+t.name+"】职位, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.loading=!0,this.deleteRequest("/system/basic/pos/"+t.id).then((e=>{this.loading=!1,e&&this.initPositions()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))}},mounted(){this.initPositions()}},E=L,q=(0,d.Z)(E,J,C,!1,null,"0531b2b8",null),j=q.exports,M={name:"SysBasic",data(){return{activeName:"first"}},components:{DeptManage:u,EcManage:b,JobLevel:w,PermissManage:D,PosManage:j}},T=M,V=(0,d.Z)(T,i,a,!1,null,"1ecfd339",null),N=V.exports},2592:function(e,t,l){l.r(t),l.d(t,{default:function(){return d}});var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[e._v(" 系统管理 ")])},a=[],s={name:"SysCfg"},n=s,o=l(1001),r=(0,o.Z)(n,i,a,!1,null,"400d7569",null),d=r.exports},4855:function(e,t,l){l.r(t),l.d(t,{default:function(){return d}});var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:e.loading,expression:"loading",modifiers:{fullscreen:!0,lock:!0}}],attrs:{"element-loading-text":"恢复数据库耗时较长，请耐心等待...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"}},[l("div",{staticStyle:{"margin-top":"20px"}},[l("p",[e._v("恢复数据库耗时较长，请谨慎选择")]),l("el-button",{attrs:{type:"primary",size:"large"},on:{click:e.open}},[e._v("恢复数据库")])],1),l("div",[e._v(e._s(e.timeCost))])])},a=[],s={name:"SysData",data(){return{timeCost:"",loading:!1}},methods:{open(){this.$confirm("此操作将恢复数据库到管理员设置的初始状态,此前修改将全部丢失， 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.loading=!0,this.getRequest("/system/init/spacehrsql/").then((e=>{this.loading=!1,e&&(this.timeCost=e.data)}))})).catch((()=>{this.$message({type:"info",message:"已取消操作"})}))}}},n=s,o=l(1001),r=(0,o.Z)(n,i,a,!1,null,"aa6f450e",null),d=r.exports},3442:function(e,t,l){l.r(t),l.d(t,{default:function(){return d}});var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[l("div",{staticStyle:{"margin-top":"10px",display:"flex","justify-content":"center"}},[l("el-input",{staticStyle:{width:"400px","margin-right":"10px"},attrs:{placeholder:"请输入用户名搜索用户"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.doSearch.apply(null,arguments)}},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}}),l("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.doSearch}},[e._v("搜索")])],1),l("div",{staticClass:"card-container"},e._l(e.hrs,(function(t,i){return l("el-card",{key:i,staticClass:"hr-card"},[l("div",{attrs:{slot:"header"},slot:"header"},[l("img",{staticClass:"userface-img",attrs:{src:t.userface,alt:t.name,title:t.name}}),e._v(" "+e._s(t.name)+" "),l("el-button",{staticStyle:{float:"right",padding:"3px 0",color:"crimson"},attrs:{size:"medium",type:"text",icon:"el-icon-delete"},on:{click:function(l){return e.doDelete(t)}}})],1),l("div",{staticClass:"userInfo-container"},[l("el-descriptions",{attrs:{direction:"vertical",column:2,border:""}},[l("el-descriptions-item",{attrs:{label:"用户名"}},[e._v(e._s(t.name))]),l("el-descriptions-item",{attrs:{label:"手机号"}},[e._v(e._s(t.phone))]),l("el-descriptions-item",{attrs:{label:"电话号码"}},[e._v(e._s(t.telephone))]),l("el-descriptions-item",{attrs:{label:"地址"}},[e._v(e._s(t.address))]),l("el-descriptions-item",{attrs:{label:"用户角色",span:4}},[e._l(t.roles,(function(t,i){return l("el-tag",{key:i,staticStyle:{"margin-right":"3px"},attrs:{size:"small"}},[e._v(" "+e._s(t.namezh)+" ")])})),l("el-popover",{attrs:{placement:"bottom",title:"角色列表",width:"200",trigger:"click"},on:{show:function(l){return e.showPop(t)},hide:function(l){return e.updateRole(t)}}},[l("el-select",{attrs:{multiple:"",placeholder:"请选择"},model:{value:e.selectedRoles,callback:function(t){e.selectedRoles=t},expression:"selectedRoles"}},e._l(e.allRoles,(function(e,t){return l("el-option",{key:t,attrs:{label:e.namezh,value:e.id}})})),1),l("el-button",{staticStyle:{"padding-right":"5px"},attrs:{slot:"reference",size:"medium",type:"text",icon:"el-icon-edit"},slot:"reference"})],1)],2),l("el-descriptions-item",{attrs:{label:"是否可用"}},[l("el-switch",{attrs:{"active-text":"可用","inactive-text":"禁用"},on:{change:function(l){return e.enabledChange(t)}},model:{value:t.enabled,callback:function(l){e.$set(t,"enabled",l)},expression:"hr.enabled"}})],1),l("el-descriptions-item",{attrs:{label:"备注"}},[e._v(e._s(t.remark))])],1)],1),l("div")])})),1)])},a=[],s={name:"SysHr",data(){return{selectedRoles:[],allRoles:[],keywords:"",hrs:[]}},mounted(){this.initHrs()},methods:{doDelete(e){this.$confirm("此操作将永久删除【"+e.name+"】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.deleteRequest("/system/hr/"+e.id).then((e=>{e&&this.initHrs()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},doSearch(){this.initHrs()},updateRole(e){let t=e.roles,l=!1,i=[];if(Object.assign(i,this.selectedRoles),t.length==i.length){for(let e=0;e<t.length;e++){let l=t[e];for(let e=0;e<i.length;e++){let t=i[e];if(t==l.id){i.splice(e,1);break}}}0==i.length&&(l=!0)}if(l)return;let a="/system/hr/role?hrid="+e.id;this.selectedRoles.forEach((e=>{a+="&rids="+e})),this.putRequest(a).then((e=>{e&&this.initHrs()}))},showPop(e){this.initAllRoles();let t=e.roles;this.selectedRoles=[],t.forEach((e=>{this.selectedRoles.push(e.id)}))},initAllRoles(){this.getRequest("/system/hr/roles/").then((e=>{e&&(this.allRoles=e.data)}))},enabledChange(e){delete e.roles,this.putRequest("/system/hr/",e).then((e=>{e&&this.initHrs()}))},initHrs(){this.getRequest("/system/hr/?keyWords="+this.keywords).then((e=>{e&&(this.hrs=e.data)}))}}},n=s,o=l(1001),r=(0,o.Z)(n,i,a,!1,null,"5c37955a",null),d=r.exports},3376:function(e,t,l){l.r(t),l.d(t,{default:function(){return d}});var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[e._v(" 初始化数据库 ")])},a=[],s={name:"SysInit"},n=s,o=l(1001),r=(0,o.Z)(n,i,a,!1,null,"487ee882",null),d=r.exports},7325:function(e,t,l){l.r(t),l.d(t,{default:function(){return d}});var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",[e._v(" 操作日志管理 ")])},a=[],s={name:"SysLog"},n=s,o=l(1001),r=(0,o.Z)(n,i,a,!1,null,"3c65c64c",null),d=r.exports}}]);
//# sourceMappingURL=860.34194992.js.map