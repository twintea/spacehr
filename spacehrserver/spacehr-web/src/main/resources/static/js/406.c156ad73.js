(self["webpackChunkvuehr"]=self["webpackChunkvuehr"]||[]).push([[406],{9174:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工奖惩 ")])},n=[],i={name:"PerEc"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"5bfc32b8",null),o=u.exports},4767:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工资料 ")])},n=[],i={name:"PerEmp"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"3c487450",null),o=u.exports},6085:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工调动 ")])},n=[],i={name:"PerMv"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"71b1f814",null),o=u.exports},2260:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工调薪 ")])},n=[],i={name:"PerSalary"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"aa8fd750",null),o=u.exports},5660:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工培训 ")])},n=[],i={name:"PerTrain"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"0115448e",null),o=u.exports},2999:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 月末处理 ")])},n=[],i={name:"SalMonth"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"47ed4ec8",null),o=u.exports},4356:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 工资表查询 ")])},n=[],i={name:"SalSearch"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"ee75f97a",null),o=u.exports},2418:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}]},[a("div",{staticStyle:{display:"flex","justify-content":"space-between"}},[a("el-button",{attrs:{icon:"el-icon-plus",type:"primary"},on:{click:e.showAddDialog}},[e._v("添加工资账套")]),a("el-button",{attrs:{icon:"el-icon-refresh",type:"success"},on:{click:e.initSalSob}})],1),a("el-dialog",{attrs:{title:e.dialogName,visible:e.addDialogView,width:"50%","before-close":e.handleClose},on:{"update:visible":function(t){e.addDialogView=t}}},[a("div",{staticStyle:{height:"300px",display:"flex","align-items":"center"}},[a("el-steps",{staticStyle:{"margin-right":"150px"},attrs:{direction:"vertical",active:e.active,"finish-status":"success"}},e._l(e.salItemName,(function(e,t){return a("el-step",{key:t,attrs:{title:e}})})),1),a("el-tag",{staticStyle:{"margin-right":"10px"}},[e._v(e._s(e.salItemName[e.active]+":"))]),e._l(e.salObj,(function(t,l,n){return a("el-input",{directives:[{name:"show",rawName:"v-show",value:n==e.active,expression:"index==active"}],key:n,staticStyle:{width:"200px"},attrs:{placeholder:"请输入"+e.salItemName[n]},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.next.apply(null,arguments)}},model:{value:e.salObj[l],callback:function(t){e.$set(e.salObj,l,t)},expression:"salObj[key]"}})}))],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{disabled:0==e.active},on:{click:e.prev}},[e._v("上一步")]),a("el-button",{attrs:{type:"primary"},on:{click:e.next}},[e._v(e._s(10==this.active?"完成":"下一步"))])],1)]),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{attrs:{data:e.salSob,stripe:"",border:""}},[a("el-table-column",{attrs:{type:"selection",width:"50"}}),a("el-table-column",{attrs:{prop:"name",label:"账套名称",width:"120"}}),a("el-table-column",{attrs:{prop:"basicSalary",label:"基本工资",width:"80"}}),a("el-table-column",{attrs:{prop:"trafficSalary",label:"交通补助",width:"80"}}),a("el-table-column",{attrs:{prop:"lunchSalary",label:"午餐补助",width:"80"}}),a("el-table-column",{attrs:{prop:"bonus",label:"奖金",width:"80"}}),a("el-table-column",{attrs:{prop:"createDate",label:"启用时间",width:"100"}}),a("el-table-column",{attrs:{label:"养老金",align:"center"}},[a("el-table-column",{attrs:{prop:"pensionper",label:"比率",width:"80"}}),a("el-table-column",{attrs:{prop:"pensionBase",label:"基数",width:"80"}})],1),a("el-table-column",{attrs:{label:"医疗保险",align:"center"}},[a("el-table-column",{attrs:{prop:"medicalper",label:"比率",width:"80"}}),a("el-table-column",{attrs:{prop:"medicalBase",label:"基数",width:"80"}})],1),a("el-table-column",{attrs:{label:"公积金",align:"center"}},[a("el-table-column",{attrs:{prop:"accumulationFundper",label:"比率",width:"80"}}),a("el-table-column",{attrs:{prop:"accumulationFundBase",label:"基数",width:"80"}})],1),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){return e.showEditDialog(t.row)}}},[e._v("编辑")]),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.doDelete(t.row)}}},[e._v("删除")])]}}])})],1)],1)],1)},n=[],i={name:"SalSob",data(){return{loading:!1,dialogName:"",active:0,salSob:[],addDialogView:!1,salItemName:["基本工资","交通补助","午餐补助","奖金","养老金比率","养老金基数","医疗保险比率","医疗保险基数","公积金比率","公积金基数","账套名称"],salObj:{basicSalary:0,trafficSalary:0,lunchSalary:0,bonus:0,pensionper:0,pensionBase:0,medicalper:0,medicalBase:0,accumulationFundper:0,accumulationFundBase:0,name:"",id:-1}}},mounted(){this.initSalSob()},methods:{showEditDialog(e){this.active=0,this.dialogName="修改工资账套",this.addDialogView=!0,this.salObj.basicSalary=e.basicSalary,this.salObj.trafficSalary=e.trafficSalary,this.salObj.lunchSalary=e.lunchSalary,this.salObj.bonus=e.bonus,this.salObj.pensionper=e.pensionper,this.salObj.pensionBase=e.pensionBase,this.salObj.medicalper=e.medicalper,this.salObj.medicalBase=e.medicalBase,this.salObj.accumulationFundper=e.accumulationFundper,this.salObj.accumulationFundBase=e.accumulationFundBase,this.salObj.name=e.name,this.salObj.id=e.id},doDelete(e){this.$confirm("此操作将永久删除该【"+e.name+"】账套, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.deleteRequest("/salary/sob/"+e.id).then((e=>{e&&this.initSalSob()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},handleClose(){this.addDialogView=!1},prev(){this.active>0&&this.active--},next(){if(this.active++>=10){if(!this.salObj.id)return void this.postRequest("/salary/sob/",this.salObj).then((e=>{e&&(this.initSalSob(),this.addDialogView=!1)}));this.putRequest("/salary/sob/",this.salObj).then((e=>{e&&(this.initSalSob(),this.addDialogView=!1)}))}},showAddDialog(){this.dialogName="添加工资账套",this.salObj={basicSalary:0,trafficSalary:0,lunchSalary:0,bonus:0,pensionper:0,pensionBase:0,medicalper:0,medicalBase:0,accumulationFundper:0,accumulationFundBase:0,name:""},this.active=0,this.addDialogView=!0},initSalSob(){this.loading=!0,this.getRequest("/salary/sob/").then((e=>{this.loading=!1,e&&(this.salSob=e.data)}))}}},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"4c3f83be",null),o=u.exports},4977:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工账套设置 ")])},n=[],i={name:"SalSobCfg"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"960520da",null),o=u.exports},5024:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 工资表管理 ")])},n=[],i={name:"SalTable"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"a124dc6a",null),o=u.exports},6818:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 综合信息统计 ")])},n=[],i={name:"StaAll"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"f6f01a96",null),o=u.exports},9317:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 人事信息统计 ")])},n=[],i={name:"StaPers"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"4f1b0808",null),o=u.exports},2583:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 人事记录统计 ")])},n=[],i={name:"StaRecord"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"3adc9842",null),o=u.exports},3015:function(e,t,a){"use strict";a.r(t),a.d(t,{default:function(){return o}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" 员工积分统计 ")])},n=[],i={name:"StaScore"},r=i,s=a(1001),u=(0,s.Z)(r,l,n,!1,null,"a2f6226e",null),o=u.exports},9305:function(e,t,a){var l={"./Home.vue":8678,"./Login.vue":7935,"./UserInfo.vue":1109,"./chat/FriendChat.vue":1274,"./emp/EmpAdv.vue":8643,"./emp/EmpBasic.vue":9150,"./exception/NoAccess.vue":1894,"./exception/NotFound.vue":7419,"./exception/SysException.vue":1443,"./per/PerEc.vue":9174,"./per/PerEmp.vue":4767,"./per/PerMv.vue":6085,"./per/PerSalary.vue":2260,"./per/PerTrain.vue":5660,"./sal/SalMonth.vue":2999,"./sal/SalSearch.vue":4356,"./sal/SalSob.vue":2418,"./sal/SalSobCfg.vue":4977,"./sal/SalTable.vue":5024,"./sta/StaAll.vue":6818,"./sta/StaPers.vue":9317,"./sta/StaRecord.vue":2583,"./sta/StaScore.vue":3015,"./sys/SysBasic.vue":1546,"./sys/SysCfg.vue":2592,"./sys/SysData.vue":4855,"./sys/SysHr.vue":3442,"./sys/SysInit.vue":3376,"./sys/SysLog.vue":7325};function n(e){var t=i(e);return a(t)}function i(e){if(!a.o(l,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return l[e]}n.keys=function(){return Object.keys(l)},n.resolve=i,e.exports=n,n.id=9305}}]);
//# sourceMappingURL=406.c156ad73.js.map