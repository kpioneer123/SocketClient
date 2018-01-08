   LOCAL_PATH := $(call my-dir)


   include $(CLEAR_VARS)
   LOCAL_MODULE    := socketlib
   LOCAL_SRC_FILES := socket_client.c
   ##使用log模块
   LOCAL_LDLIBS := -llog

   include $(BUILD_SHARED_LIBRARY)