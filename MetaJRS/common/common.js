//定义全局变量
const baseurl = 'https://metajrs.pek3b.qingstor.com'
const teaminfodata = {}
const teaminfo={}
const directions=[]
const chats=[]
const news=[]

//定义全局函数
function init(){
	uni.request({
	       url: 'https://metajrs.pek3b.qingstor.com/json/teamintro.json',
	       method: 'get',
	       success: res => {
			 let table=JSON.parse(JSON.stringify(res.data))
	         this.teaminfodata = table;
			 this.teaminfo=this.teaminfodata.teaminfo
			 this.directions=this.teaminfodata.directions
	        
			 //console.log(this.directions)
		   
		   }
	     });
	
    uni.request({
           url: 'https://metajrschat.pek3b.qingstor.com/json/chats.json',
           method: 'get',
           success: res => {
             this.chats = res.data;
    		
           }
         });
		 uni.request({
		        url: 'https://metajrs.pek3b.qingstor.com/json/news.json',
		        method: 'get',
		        success: res => {
		          this.news = res.data;
		 		
		        }
		      });
	
    
}
//导出
module.exports = {
	init,
	baseurl,
	teaminfodata,
	teaminfo,
	directions
}