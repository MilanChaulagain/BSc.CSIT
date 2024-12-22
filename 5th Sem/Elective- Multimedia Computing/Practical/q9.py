import numpy as np
import matplotlib.pyplot as plt
# set parameters for sine wave
freq = 3 # frequency in Hz
amp = 1 # amplitude
phase = 0 # phase angle in radians
# define sampling rate and calculate Nyquist frequency
sampling_rate = 30 # in Hz
nyquist_freq = sampling_rate / 2
# generate time array with sampling rate
t = np.arange(0, 10, 1/sampling_rate)
# generate samples of sine wave
y = amp * np.sin(2 * np.pi * freq * t + phase)
# plot the sine wave
plt.plot(t, y, 'r-', linewidth=2)
plt.xlabel('Time (s)')
plt.ylabel('Amplitude')
plt.title('Sine Wave with f = 3 Hz, Sampling Rate = 30 Hz')
plt.grid()
plt.show()