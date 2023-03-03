<template>
	
	<form @submit="formCompany" @reset="formReset">
	<view class="uni-form-item uni-column" style="background-color:azure;">
		<!-- <view class="title1">宝贵建议</view> -->
		<editor   placeholder="" id="editor" class="msgwall" :placeholder="placeholder" @input="onInput"  ></editor>
	</view>
						
	<view class="uni-btn-v">
		<!-- <input hidden='true' @input="onInput" v-model="gongsijieshao" name='gongsijieshao' /> -->
		<button open-type="getUserInfo" lang="zh_CN" @getuserinfo="onGotUserInfo" @click="sendchats" class="button-yuanjiao" hover-class="bg-click" >发布</button>
	</view>
	</form>
</template>

<script>

import common from '@/common/common.js'	
	export default {
		data() {
				return {
						
						chats:[],
						text:"",
						nickname:'',
						avatarurl:''
		
					}
				},
				components: {
					// crop
				},
				mounted(){
				  
				
				},
				methods: {
					
					onInput(e){
						this.text=e.detail.text;
					},
					/**
					* 用户同意授权个人微信信息
					* @param {Object} e 用户的信息
					*/
					onGotUserInfo(e) {
						this.nickname=e.detail.userInfo.nickName
						this.avatarurl=e.detail.userInfo.avatarUrl
					    
					},
					
					 onEditorReady() {
						const that = this
		                uni.createSelectorQuery().select('#editor').context((res) => {
							
		                    this.editorCtx = res.context
							this.editorCtx.setContents({
								'html':'',
								success:(res)=> {
									console.log(res,"res")
								},
								fail:(res)=> {
									
									},
									})
		                }).exec()
		            },
					sendchats:function(e){
						this.chats=common.chats;
						if (!this.text==''&& this.nickname!="" && this.avatarurl!="") {
							this.jsonadd(this.chats);
						} else {
							if (this.nickname=="" || this.avatarurl=="") {
								uni.showToast({
												title: "授权登入失败，请稍等",
												icon:'exception',
												duration:1000
								});
							} else{
								uni.showToast({
												title: "请输入留言噢",
												icon:'exception',
												duration:1000
								});
							}
							
						}
					   
								
						      
					},
					dateFormat(time) {
									let date = new Date(time);
									let year = date.getFullYear();
									// 在日期格式中，月份是从0开始的，因此要加0，使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
									let month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
									let day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
									let hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
									let minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
									let seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
									// 拼接
									return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
									// return year + "-" + month + "-" + day;
					},

					jsonadd:function(e){
						var json={};
						var time = new Date().toISOString();
						json.content=this.text;
						json.date=this.dateFormat(time);
						json.type="image";
						json.nickname=this.nickname;
						json.avatar=this.avatarurl;
						e.unshift(json)
						//e[e.length]=json;
						uni.request({
						       url: 'https://metajrschat.pek3b.qingstor.com/json/chats.json',
						       method: 'put',
							   data:e,
							   dataType:json,
						       success: res => {
							        uni.showToast({
							        				title: "留言成功，感谢反馈！",
							        				icon:'exception',
							        				duration:1000
							        });
							   }
						     });
						uni.createSelectorQuery().select('#editor').context((res) => {
							
						    this.editorCtx = res.context
							this.editorCtx.setContents({
								'html':'',
								success:(res)=> {
									this.text='';
								},
								fail:(res)=> {
									
									},
									})
						}).exec()
						/* changeData(common.baseurl+"/json/chats.json", 0,e); */
					}, 
					
				}

}
</script>

<style lang="scss">
@import './add.scss'
</style>
