<template>
  <div class="fullscreen-carousel">
    <el-carousel ref="carousel" :autoplay="true" height="100vh" :interval="fileFile[currentIndex].seconds" arrow="always" @change="handleCarouselChange" @mouseenter.native="delHandleMouseEnter">
      <el-carousel-item v-for="(item, index) in fileFile" :key="index" label="" style="text-align: center;" >
        <div class="carousel-item-content" v-if="item.fileType == '.png' || item.fileType == '.jpg' || item.fileType == '.jpeg'  ">
          <img :src="getImageUrl(item.downloadPath)" :style="{ maxHeight: '100vh', maxWidth: '100%', margin: 'auto', position: 'relative', top: '50%', transform: 'translateY(-50%)' }" @load="calculateImageSize(index)" />
          <p class="carousel-text" :style="{color: item.fontColor}">{{item.introduceText}}</p> 
        </div>
        <div v-else>
          <video width="100%" height="100%" autoplay loop muted controls :src="getImageUrl2(item.downloadPath)">
          </video>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
import { findByCarouselId } from '@/api/carousel_file';
import { getShowList } from '@/api/carousel_list';
export default {
  data() {
    return {
      currentIndex: 0,
      fileFile: [],
      imgWidth: 0,
      imgHeight: 0,
      screenWidth: 0 // 保存全屏的宽度
    };
  },
  methods: {
    handleCarouselChange(index) {
      this.currentIndex = index;
    },
    findByCarouselIdHandler() {
      getShowList({ "showId": this.$route.params.id })
        .then(res => {
          this.fileFile = res.data.data;
        })
        .catch(error => {
          console.error('Error fetching carousel data:', error);
          // Handle error: show error message, retry, etc.
        });
    },
    getImageUrl2(val){
      return "http://" + window.location.hostname + ":" + window.location.port + "/file/getVideo?imgUrl=" + val;
    },
    calculateImageSize(index) {
      const containerWidth = window.innerWidth; // 获取窗口的宽度
      const containerHeight = window.innerHeight; // 获取窗口的高度
      this.screenWidth = containerWidth; // 保存全屏的宽度

      const img = new Image();
      img.src = this.getImageUrl(this.fileFile[index].downloadPath);
      img.onload = () => {
        this.imgWidth = img.width; // 获取图片的原始宽度
        this.imgHeight = img.height; // 获取图片的原始高度

        if (this.imgHeight < containerHeight) {
          // 图片高度小于窗口高度，需要缩放以填满整个窗口高度
          const scale = containerHeight / this.imgHeight;
          this.imgHeight *= scale;
          this.imgWidth *= scale;
        }

        if (this.imgWidth > containerWidth) {
          // 图片宽度大于窗口宽度，需要缩放以适应窗口宽度
          const scale = containerWidth / this.imgWidth;
          this.imgWidth *= scale;
          this.imgHeight *= scale;
        }
      };
    },
    getImageUrl(val){
      return "http://" + window.location.hostname + ":" + window.location.port + "/file/getFile?imgUrl=" + val;
    },
    delHandleMouseEnter() {
      this.$refs.carousel.handleMouseEnter = () => {};
    },
    enterFullscreen() {
      const elem = document.documentElement;
      if (elem.requestFullscreen) {
        elem.requestFullscreen();
      } else if (elem.webkitRequestFullscreen) {
        elem.webkitRequestFullscreen();
      } else if (elem.msRequestFullscreen) {
        elem.msRequestFullscreen();
      }
    },
  },
  mounted() {
    //this.enterFullscreen(); // 自动全屏
    this.findByCarouselIdHandler();
  }
};
</script>

<style scoped>
.fullscreen-carousel {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 9999; /* 确保在最顶层显示 */
}

.carousel-item-content {
  position: relative;
  width: 100%;
  height: 100%;
}

.carousel-text {
  position: absolute;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  font-size: 50px;
  font-weight: bold;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}
</style>
