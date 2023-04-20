// pages/menu/menu.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    multiSelectorItems: [
      ['二区食堂', '七区食堂'],
      ['一楼', '二楼', '三楼'],
      ['11:30-12：00', '12:00-12:30', '12:30-13:00', '13:00-13:30']
    ],
    canteen_class: '',
    remainPosition: 20,
    defaultShowIndex: 1,
    hiddenName:true,
    menuArr: [{
        "id": 0,
        "title": "一号窗口",
        "subArr": [{
            "imgSrc": "/Images/menu/u11.jpg",
            "imgDesc": "火腿炒饭",
            "value":"12.00"
          },
          {
            "imgSrc": "/Images/menu/u12.jpg",
            "imgDesc": "蛋炒饭",
            "value":"13.00"
          },
          {
            "imgSrc": "/Images/menu/u13.jpg",
            "imgDesc": "八宝粥",
            "value":"11.00"
          },
          {
            "imgSrc": "/Images/menu/u14.jpg",
            "imgDesc": "莲子粥",
            "value":"14.00"
          }
        ]
      },
      {
        "id": 1,
        "title": "二号窗口",
        "subArr": [{
            "imgSrc": "/images/menu/u21.jpg",
            "imgDesc": "蛋汤面",
            "value":"12.00"
          },
          {
            "imgSrc": "/images/menu/u22.jpg",
            "imgDesc": "牛肉面",
            "value":"15.00"
          },
          {
            "imgSrc": "/images/menu/u23.jpg",
            "imgDesc": "肉丝面",
            "value":"13.00"
          }
        ]
      },
      {
        "id": 2,
        "title": "三号窗口",
        "subArr": [{
            "imgSrc": "/images/menu/u24.jpg",
            "imgDesc": "刀削面",
            "value":"11.00"
          },
          {
            "imgSrc": "/images/menu/32.jpg",
            "imgDesc": "三色果汁",
            "value":"10.00"
          },
          {
            "imgSrc": "/images/menu/33.jpg",
            "imgDesc": "柠檬果汁",
            "value":"11.00"
          },
          {
            "imgSrc": "/images/menu/34.jpg",
            "imgDesc": "西瓜蜜桃汁",
            "value":"10.00"
          },
          {
            "imgSrc": "/images/menu/35.jpg",
            "imgDesc": "鲜橙汁",
            "value":"11.00"
          },
          {
            "imgSrc": "/images/menu/36.jpg",
            "imgDesc": "草莓果汁",
            "value":"12.00"
          }
         
        ]
      },
      {
        "id": 3,
        "title": "四号窗口",
        "subArr": [{
          "imgSrc": "/images/menu/41.jpg",
          "imgDesc": "大披萨",
          "value":"28.00"
        }]
      },
      {
        "id": 4,
        "title": "五号窗口",
        "subArr": [{
            "imgSrc": "/images/menu/51.jpg",
            "imgDesc": "牛肉芹菜包",
            "value":"9.00"
          },
          {
            "imgSrc": "/images/menu/52.jpg",
            "imgDesc": "三鲜煎饺",
            "value":"8.00"
          },
          {
            "imgSrc": "/images/menu/53.jpg",
            "imgDesc": "海鲜馄饨",
            "value":"10.00"
          },
          {
            "imgSrc": "/images/menu/37.jpg",
            "imgDesc": "大杯西瓜汁",
            "value":"11.00"
          },
          {
            "imgSrc": "/images/menu/38.jpg",
            "imgDesc": "蓝莓汁",
            "value":"12.00"
          }
        ]
      },
    
    ],
    leftId: "left0",
    rightId: "right0",
    lifeActiveNum: 0,
    heightArr: []
  },
  clickMe:function(e){
    this.setData({
      hiddenName:!this.data.hiddenName
    })
  },
  leftClick(e) {
    this.setData({
      lifeActiveNum: e.target.dataset.myid,
      leftId: "left" + e.target.dataset.myid,
      rightId: "right" + e.target.dataset.myid
    })

  },
  multiSelectorChange: function (e) {
    let arrayIndex = e.detail.value;
    let array = this.data.multiSelectorItems;
    let value = new Array();
    for (let i = 0; i < arrayIndex.length; i++) {
      let k = arrayIndex[i];
      let v = array[i][k];
      value.push(v);

    }
    this.setData({
      multiSelector: value
    });
  },


  // 获取窗口列表
  getWindewsList() {
    let times;
    // if (this.data.time == "时间段11:30-12:00") {
    //   times = "1";
    // } else if (this.data.time == "时间段12:00-12:30") {
    //   times = "2";
    // } else if (this.data.time == "时间段12:30-13:00") {
    //   times = "3";
    // } else if (this.data.time == "时间段13:00-13:30") {
    //   times = "4";
    // } else if (this.data.time == "时间段13:30-14:00") {
    //   times = "5"
    // }
    const that = this;
    wx.request({
      url: 'http://localhost:8888/canteen/visitor/windows',
      data: {
        canteen: this.data.canteen,
        tier: this.data.tier,
        time: times
      },
      method: 'POST',
      header: {
        //'content-type': 'application/json' // 默认值
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success(res) {
        console.log(res);
        if (res.data.flag) {
          that.setData({
            windowsList: res.data.objects,
            remainPosition: res.data.data,
          })
          getApp().globalData.time_id = res.data.errorMsg
        }
      }
    });
  },

  getButtonWindewsList: function () {
    this.getWindewsList();
  },

  windowsEat: function () {

  },
  popBaitiaoView(e) {
    console.log(e)
    this.setData({
      defaultShowIndex: e.detail.activeIndex.showIndex
    })
    if (this.data.defaultShowIndex == 0) {
      wx.reLaunch({
        url: '/pages/admin/admin',
      })
    }
    if (this.data.defaultShowIndex == 1) {
      wx.switchTab({
        url: '/pages/menu/menu',
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    let _this = this
    setTimeout(() => {
      let initArr = [0]; //初始数组
      let initNum = 0; //初始数值
      const query = wx.createSelectorQuery()
      query.selectAll('.rightblock').boundingClientRect()
      query.selectViewport().scrollOffset()
      query.exec(function (res) {
        console.log(res[0]);
        res[0].map(val => {
          initNum += val.height; //实现高度的累加
          initArr.push(initNum) //初始数值加进数组中
        })
        console.log(initArr); //拿到每一个height  存起来
        _this.setData({
          heightArr: initArr
        })
      })
    }, 300)
  },
  // 右边滚动事件
  rightScrollTop(e) {
    let st = e.detail.scrollTop;
    let myarr = this.data.heightArr;
    for (let i = 0; i < myarr.length; i++) {
      if (st >= myarr[i] && st < myarr[i + 1] - 10) {
        this.setData({
          leftId: "left" + i,
          lifeActiveNum: i
        })
        return;
      }

    }
  },

/**
 * 生命周期函数--监听页面显示
 */
onShow: function () {
    this.getWindewsList();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})