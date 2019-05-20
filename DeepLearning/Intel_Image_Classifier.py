from keras.layers.core import Dense, Flatten
from keras.layers.normalization import BatchNormalization
from keras.layers.convolutional import Conv2D, MaxPooling2D
from keras_preprocessing.image import ImageDataGenerator
from keras.optimizers import Adam, RMSprop
from keras.models import Sequential
from keras.callbacks import EarlyStopping
from keras.losses import categorical_crossentropy
from keras.applications.vgg16 import VGG16
from graphs import plot_results
import os


train_data = r"C:\Users\fabio\Documents\DataSets\yalefaces\train"
#validation_data = r"C:\Users\fabio\Documents\DataSets\IntelClassifier\seg_test"
test_data = r"C:\Users\fabio\Documents\DataSets\yalefaces\test"

pretrained_model = VGG16(weights='imagenet',
                         include_top=False,
                         input_shape=(100, 100, 3))


train_datagen = ImageDataGenerator(rescale=1./255)
train_generator = train_datagen.flow_from_directory(directory=train_data,
                                                    target_size=(50, 50),
                                                    class_mode='categorical',
                                                    batch_size=5)

'''validation_datagen = ImageDataGenerator(rescale=1./255)
validation_generator = validation_datagen.flow_from_directory(directory=validation_data,
                                                              target_size=(100, 100),
                                                              class_mode='categorical',
                                                              batch_size=50
                                                              )'''

test_datagen = ImageDataGenerator(rescale=1./255)
test_generator = test_datagen.flow_from_directory(directory=test_data,
                                                  target_size=(100, 100),
                                                  batch_size=1,
                                                  class_mode='categorical',
                                                  shuffle=False,
                                                  color_mode='rgb'
                                                  )

model = Sequential([Conv2D(12, kernel_size=(5, 5), activation='relu', input_shape=(100, 100, 3)),
                    Conv2D(32, kernel_size=(3, 3), activation='relu'),
                    MaxPooling2D(2, 2),
                    Conv2D(64, kernel_size=(3, 3), activation='relu'),
                    Conv2D(82, kernel_size=(3, 3), activation='relu'),
                    Conv2D(92, kernel_size=(3, 3), activation='relu'),
                    MaxPooling2D(2, 2),
                    Conv2D(128, kernel_size=(3, 3), activation='relu'),
                    Conv2D(132, kernel_size=(1, 1), activation='relu'),
                    MaxPooling2D(2, 2),
                    BatchNormalization(),
                    Conv2D(182, kernel_size=(1, 1), activation='relu'),
                    MaxPooling2D(2, 2),
                    Flatten(),
                    Dense(250, activation='relu'),
                    Dense(len(os.listdir(train_data)), activation='softmax')])

model.compile(loss=categorical_crossentropy,
              optimizer=Adam(),
              metrics=['acc'])

callback = [EarlyStopping(patience=5)]

hist = model.fit_generator(train_generator,
                           steps_per_epoch=50,
                           epochs=10,
                           callbacks=callback)


loss = hist.history['loss']
val_loss = hist.history['val_loss']

train_acc = hist.history['acc']
val_acc = hist.history['val_acc']

epochs = range(1, 1 + len(loss))

plot_results(epochs, train_loss=loss, train_acc=train_acc, val_loss=val_loss, val_acc=val_acc)

test_samples = len(os.listdir(test_data))
test_loss, test_acc = model.predict_generator(test_generator,
                                              steps=test_samples)
print('Test acc:', test_acc)