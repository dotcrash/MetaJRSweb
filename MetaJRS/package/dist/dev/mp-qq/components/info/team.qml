<uni-list vue-id="cb8a8486-1" class="data-v-cb8a5d1a" bind:__l="__l" vue-slots="{{['default']}}"><block qq:for="{{team_news}}" qq:for-item="item" qq:for-index="__i0__"><uni-list-item vue-id="{{('cb8a8486-2-'+__i0__)+','+('cb8a8486-1')}}" direction="row" title="{{item.title}}" note="{{item.from+' '+item.date}}" class="data-v-cb8a5d1a" bind:__l="__l" vue-slots="{{['header']}}"><view slot="header"><block qq:if="{{item.type=='video'}}"><view class="m-video data-v-cb8a5d1a"><video class="u-video data-v-cb8a5d1a" src="{{item.vedio}}" mode="aspectFill"></video></view></block><view class="img-box data-v-cb8a5d1a"><swiper class="m-banner data-v-cb8a5d1a" indicator-dots="{{swiper.indicatorDots}}" indicator-color="{{swiper.indicatorColor}}" indicator-active-color="{{swiper.indicatorActiveColor}}" autoplay="{{swiper.autoplay}}" interval="{{swiper.interval}}" duration="{{swiper.duration}}"><block qq:for="{{item.photos}}" qq:for-item="itemc" qq:for-index="__i1__"><swiper-item class="swiper-item data-v-cb8a5d1a"><image src="{{itemc.url}}" mode class="data-v-cb8a5d1a"></image></swiper-item></block></swiper></view></view></uni-list-item></block></uni-list>