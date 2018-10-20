#include <jni.h>
#include <string.h>
#include <string>
#include "fstream"
#include "time.h"

std::string Res = "";
std::string Res2 = "";
std::string st = "STOP";
int a=0,b=0;
std::string str[200];
std::string str2[200];
int index2=10;
extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_danch_kanarand_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Imput(JNIEnv *env, jobject instance, jstring a_) {
    const char *cstr = env->GetStringUTFChars(a_, NULL);
    if(cstr!=st) {
        str[b] = cstr;
        b++;
    }
    return 0;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Imput2(JNIEnv *env, jobject instance, jstring a_) {
    const char *cstr = env->GetStringUTFChars(a_, NULL);
    if(cstr!=st)
    {
        str2[a] = cstr;
        a++;
    }

    return 0;
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_OutPutRand(JNIEnv *env, jobject instance) {

    return env->NewStringUTF(Res.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_OutPutLat(JNIEnv *env, jobject instance) {

    return env->NewStringUTF(Res2.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Clean(JNIEnv *env, jobject instance) {


    for (int i = 0; i < b; i++) {
        str[i] = "";
        str2[i] = "";
    }
    Res = "";
    b = 0;
    a=0;
    return 0;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Rand(JNIEnv *env, jobject instance) {
    int index;
    index = 1 + rand() % b;
    if(index==index2)
    {
            index = 1 + rand() % b;


    }
    index2 =index;
    Res = str[index-1];
    Res2 = str2[index-1];
    return 0;
}