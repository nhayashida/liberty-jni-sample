#include <stdio.h>
#include <jni.h>
#include "dev_nhayashida_liberty_jni_sample_JNISample.h"

JNIEXPORT jstring JNICALL Java_dev_nhayashida_liberty_jni_sample_JNISample_getMessage(JNIEnv *env, jobject jobj) {
  return (*env)->NewStringUTF(env, "message from C code"); 
}
